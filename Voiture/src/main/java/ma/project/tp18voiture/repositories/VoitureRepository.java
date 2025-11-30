package ma.project.tp18voiture.repositories;

import ma.project.tp18voiture.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface Repository pour l'accès aux données de l'entité Voiture.
 * Hérite de JpaRepository pour bénéficier des opérations CRUD standard.
 * Inclut des méthodes personnalisées pour la recherche par propriétaire.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    
    /**
     * Recherche toutes les voitures appartenant à un propriétaire spécifique.
     * 
     * @param identifiantProprietaire L'identifiant du client propriétaire
     * @return Liste des voitures associées au propriétaire
     */
    List<Voiture> findByIdentifiantProprietaire(Long identifiantProprietaire);
}
