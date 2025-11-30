package ma.project.tp18client.controllers;

import ma.project.tp18client.entities.Client;
import ma.project.tp18client.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des clients.
 * Expose les endpoints HTTP pour les opérations CRUD sur les clients.
 * Ce contrôleur est accessible via le Gateway pour les autres microservices.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@RestController
public class ClientController {
    
    /**
     * Repository injecté pour l'accès aux données Client.
     */
    @Autowired
    private ClientRepository repositoryClient;

    /**
     * Récupère la liste complète de tous les clients enregistrés.
     * 
     * @return Liste de tous les clients présents dans la base de données
     */
    @GetMapping("/clients")
    public List<Client> recupererTousLesClients() {
        return repositoryClient.findAll();
    }

    /**
     * Recherche et retourne un client spécifique par son identifiant.
     * 
     * @param identifiantClient L'identifiant unique du client recherché
     * @return Le client correspondant à l'identifiant fourni
     * @throws Exception Si aucun client n'est trouvé avec l'identifiant spécifié
     */
    @GetMapping("/client/{id}")
    public Client recupererClientParId(@PathVariable("id") Long identifiantClient) throws Exception {
        return repositoryClient.findById(identifiantClient)
                .orElseThrow(() -> new Exception("Client avec l'identifiant " + identifiantClient + " non trouvé"));
    }
}