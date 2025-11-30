package ma.project.tp18voiture.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entité représentant une voiture dans le système.
 * Cette classe est mappée à la table "voiture" dans la base de données.
 * Elle contient une référence transiente vers le client propriétaire.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    /**
     * Identifiant unique de la voiture.
     * Généré automatiquement par la base de données.
     */
    @Id
    @GeneratedValue
    private Long identifiantVoiture;
    
    /**
     * Marque du constructeur de la voiture (ex: Toyota, Renault).
     */
    @Column(name = "marque_constructeur")
    private String marqueConstructeur;
    
    /**
     * Numéro d'immatriculation unique de la voiture.
     */
    @Column(name = "numero_immatriculation")
    private String numeroImmatriculation;
    
    /**
     * Modèle spécifique de la voiture (ex: Corolla, Megane).
     */
    @Column(name = "modele_voiture")
    private String modeleVoiture;
    
    /**
     * Identifiant du client propriétaire de la voiture.
     * Clé étrangère vers le microservice Client.
     */
    @Column(name = "identifiant_proprietaire")
    private Long identifiantProprietaire;
    
    /**
     * Objet Client propriétaire de la voiture.
     * Non persisté en base (Transient), récupéré via Feign.
     */
    @Transient
    @ManyToOne
    private Client proprietaire;
}