package ma.project.tp18voiture.services;

import ma.project.tp18voiture.entities.Voiture;
import ma.project.tp18voiture.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service métier pour la gestion des voitures.
 * Encapsule la logique métier et les validations avant la persistance.
 * Utilise le repository pour l'accès aux données.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Service
public class VoitureService {

    /**
     * Repository injecté pour l'accès aux données Voiture.
     */
    @Autowired
    private VoitureRepository repositoryVoiture;

    /**
     * Enregistre une nouvelle voiture dans la base de données.
     * Permet d'ajouter des validations métier avant la sauvegarde.
     * 
     * @param nouvelleVoiture L'objet Voiture à persister
     * @return La voiture sauvegardée avec son identifiant généré
     */
    public Voiture sauvegarderNouvelleVoiture(Voiture nouvelleVoiture) {
        // Possibilité d'ajouter des validations métier ici
        return repositoryVoiture.save(nouvelleVoiture);
    }

    /**
     * Met à jour les informations d'une voiture existante.
     * 
     * @param voitureModifiee L'objet Voiture avec les nouvelles informations
     * @return La voiture mise à jour
     */
    public Voiture mettreAJourVoiture(Voiture voitureModifiee) {
        return repositoryVoiture.save(voitureModifiee);
    }
}