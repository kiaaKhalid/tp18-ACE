package ma.project.tp18voiture.controllers;

import ma.project.tp18voiture.entities.Client;
import ma.project.tp18voiture.entities.Voiture;
import ma.project.tp18voiture.repositories.VoitureRepository;
import ma.project.tp18voiture.services.ClientService;
import ma.project.tp18voiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

/**
 * Contrôleur REST pour la gestion des voitures.
 * Expose les endpoints HTTP pour les opérations CRUD sur les voitures.
 * Communique avec le microservice Client via OpenFeign pour enrichir les données.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@RestController
public class VoitureController {

    /**
     * Repository injecté pour l'accès direct aux données Voiture.
     */
    @Autowired
    private VoitureRepository repositoryVoiture;

    /**
     * Service métier injecté pour les opérations sur les voitures.
     */
    @Autowired
    private VoitureService serviceVoiture;
    
    /**
     * Service Feign injecté pour la communication avec le microservice Client.
     */
    @Autowired
    private ClientService serviceClient;

    /**
     * Récupère la liste complète de toutes les voitures enregistrées.
     * 
     * @return ResponseEntity contenant la liste des voitures ou un message d'erreur
     */
    @GetMapping(value = "/voitures", produces = {"application/json"})
    public ResponseEntity<Object> recupererToutesLesVoitures() {
        try {
            List<Voiture> listeVoitures = repositoryVoiture.findAll();
            return ResponseEntity.ok(listeVoitures);
        } catch (Exception exceptionRecuperation) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération des voitures: " + exceptionRecuperation.getMessage());
        }
    }

    /**
     * Recherche et retourne une voiture spécifique par son identifiant.
     * Enrichit les données avec les informations du propriétaire via Feign.
     * 
     * @param identifiantVoiture L'identifiant unique de la voiture recherchée
     * @return ResponseEntity contenant la voiture ou un message d'erreur
     */
    @GetMapping("/voitures/{id}")
    public ResponseEntity<Object> recupererVoitureParId(@PathVariable("id") Long identifiantVoiture) {
        try {
            Voiture voitureTrouvee = repositoryVoiture.findById(identifiantVoiture)
                    .orElseThrow(() -> new Exception("Voiture introuvable avec l'identifiant: " + identifiantVoiture));

            // Enrichissement des données avec les informations du propriétaire
            voitureTrouvee.setProprietaire(serviceClient.recupererClientParIdentifiant(voitureTrouvee.getIdentifiantProprietaire()));

            return ResponseEntity.ok(voitureTrouvee);
        } catch (Exception exceptionRecherche) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Voiture non trouvée avec l'identifiant: " + identifiantVoiture);
        }
    }

    /**
     * Récupère toutes les voitures appartenant à un client spécifique.
     * 
     * @param identifiantClient L'identifiant du client propriétaire
     * @return ResponseEntity contenant la liste des voitures du client
     */
    @GetMapping("/voitures/client/{id}")
    public ResponseEntity<List<Voiture>> recupererVoituresParProprietaire(@PathVariable("id") Long identifiantClient) {
        try {
            Client proprietaireTrouve = serviceClient.recupererClientParIdentifiant(identifiantClient);
            if (proprietaireTrouve != null) {
                List<Voiture> voituresProprietaire = repositoryVoiture.findByIdentifiantProprietaire(identifiantClient);
                return ResponseEntity.ok(voituresProprietaire);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception exceptionRecherche) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Crée une nouvelle voiture et l'associe à un client existant.
     * 
     * @param identifiantProprietaire L'identifiant du client propriétaire
     * @param nouvelleVoiture Les données de la voiture à créer
     * @return ResponseEntity contenant la voiture créée ou un message d'erreur
     */
    @PostMapping("/voitures/{clientId}")
    public ResponseEntity<Object> creerNouvelleVoiture(
            @PathVariable("clientId") Long identifiantProprietaire, 
            @RequestBody Voiture nouvelleVoiture) {
        try {
            Client proprietaire = serviceClient.recupererClientParIdentifiant(identifiantProprietaire);

            if (proprietaire != null) {
                nouvelleVoiture.setProprietaire(proprietaire);
                nouvelleVoiture.setIdentifiantProprietaire(identifiantProprietaire);
                Voiture voitureSauvegardee = serviceVoiture.sauvegarderNouvelleVoiture(nouvelleVoiture);
                return ResponseEntity.ok(voitureSauvegardee);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Client propriétaire non trouvé avec l'identifiant: " + identifiantProprietaire);
            }
        } catch (Exception exceptionCreation) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création de la voiture: " + exceptionCreation.getMessage());
        }
    }

    /**
     * Met à jour les informations d'une voiture existante.
     * Seuls les champs non vides sont mis à jour.
     * 
     * @param identifiantVoiture L'identifiant de la voiture à modifier
     * @param voitureModifiee Les nouvelles données de la voiture
     * @return ResponseEntity contenant la voiture mise à jour ou un message d'erreur
     */
    @PutMapping("/voitures/{id}")
    public ResponseEntity<Object> mettreAJourVoiture(
            @PathVariable("id") Long identifiantVoiture, 
            @RequestBody Voiture voitureModifiee) {
        try {
            Voiture voitureExistante = repositoryVoiture.findById(identifiantVoiture)
                    .orElseThrow(() -> new Exception("Voiture non trouvée avec l'identifiant: " + identifiantVoiture));

            // Mise à jour conditionnelle des champs non vides
            if (voitureModifiee.getNumeroImmatriculation() != null && !voitureModifiee.getNumeroImmatriculation().isEmpty()) {
                voitureExistante.setNumeroImmatriculation(voitureModifiee.getNumeroImmatriculation());
            }
            if (voitureModifiee.getMarqueConstructeur() != null && !voitureModifiee.getMarqueConstructeur().isEmpty()) {
                voitureExistante.setMarqueConstructeur(voitureModifiee.getMarqueConstructeur());
            }
            if (voitureModifiee.getModeleVoiture() != null && !voitureModifiee.getModeleVoiture().isEmpty()) {
                voitureExistante.setModeleVoiture(voitureModifiee.getModeleVoiture());
            }

            Voiture voitureSauvegardee = repositoryVoiture.save(voitureExistante);
            return ResponseEntity.ok(voitureSauvegardee);

        } catch (Exception exceptionMiseAJour) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la mise à jour de la voiture: " + exceptionMiseAJour.getMessage());
        }
    }
}