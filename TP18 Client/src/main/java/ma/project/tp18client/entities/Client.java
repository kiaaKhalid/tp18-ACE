package ma.project.tp18client.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entité représentant un client dans le système.
 * Cette classe est mappée à la table "client" dans la base de données H2.
 * Elle utilise Lombok pour générer automatiquement les getters, setters et constructeurs.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    
    /**
     * Identifiant unique du client.
     * Généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue
    private Long identifiant;
    
    /**
     * Nom complet du client.
     */
    @Column(name = "nom_complet")
    private String nomComplet;
    
    /**
     * Âge du client en années.
     */
    @Column(name = "age_client")
    private Float ageClient;
}