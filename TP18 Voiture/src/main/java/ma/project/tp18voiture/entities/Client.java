package ma.project.tp18voiture.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe DTO représentant un client récupéré depuis le microservice Client.
 * Cette classe n'est pas une entité JPA car elle représente des données
 * provenant d'un service externe via OpenFeign.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    /**
     * Identifiant unique du client.
     */
    private Long identifiant;
    
    /**
     * Nom complet du client.
     */
    private String nomComplet;
    
    /**
     * Âge du client en années.
     */
    private Float ageClient;
}
