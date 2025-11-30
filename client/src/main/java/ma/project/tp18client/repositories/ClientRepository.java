package ma.project.tp18client.repositories;

import ma.project.tp18client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Repository pour l'accès aux données de l'entité Client.
 * Hérite de JpaRepository pour bénéficier des opérations CRUD standard.
 * Spring Data JPA génère automatiquement l'implémentation de cette interface.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Les méthodes CRUD de base sont héritées de JpaRepository
    // Méthodes personnalisées peuvent être ajoutées ici si nécessaire
}
