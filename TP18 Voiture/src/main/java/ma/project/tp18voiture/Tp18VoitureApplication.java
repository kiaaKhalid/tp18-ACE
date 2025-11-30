package ma.project.tp18voiture;

import ma.project.tp18voiture.entities.Client;
import ma.project.tp18voiture.entities.Voiture;
import ma.project.tp18voiture.repositories.VoitureRepository;
import ma.project.tp18voiture.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * Classe principale de l'application microservice Voiture.
 * Cette application gère les opérations CRUD pour les entités Voiture.
 * Elle utilise OpenFeign pour communiquer avec le microservice Client.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Tp18VoitureApplication {

    /**
     * Point d'entrée principal de l'application Spring Boot.
     * Lance l'initialisation du contexte Spring et démarre le serveur embarqué.
     * 
     * @param argumentsLigneCommande Les arguments passés en ligne de commande
     */
    public static void main(String[] argumentsLigneCommande) {
        SpringApplication.run(Tp18VoitureApplication.class, argumentsLigneCommande);
    }

    /**
     * Bean d'initialisation de la base de données H2 pour les voitures.
     * Crée des données de test en associant des voitures aux clients existants.
     * Utilise le service Feign pour récupérer les informations des clients.
     * 
     * @param repositoryVoiture Le repository pour l'accès aux données Voiture
     * @param serviceClient Le service Feign pour communiquer avec le microservice Client
     * @return Un CommandLineRunner qui exécute l'initialisation des données
     */
    @Bean
    CommandLineRunner chargerDonneesVoitures(VoitureRepository repositoryVoiture, ClientService serviceClient) {
        return parametresExecution -> {
            try {
                // Récupération des clients depuis le microservice CLIENT via Feign
                Client premierClient = serviceClient.recupererClientParIdentifiant(1L);
                Client deuxiemeClient = serviceClient.recupererClientParIdentifiant(2L);

                System.out.println("**************************");
                System.out.println("Deuxième client récupéré : " + deuxiemeClient.getNomComplet());
                System.out.println("Premier client récupéré : " + premierClient.getNomComplet());
                System.out.println("**************************");

                // Insertion des voitures de démonstration avec association aux clients
                repositoryVoiture.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, deuxiemeClient));
                repositoryVoiture.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, deuxiemeClient));
                repositoryVoiture.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, premierClient));

                System.out.println("Données des voitures initialisées avec succès.");
            } catch (Exception exceptionInitialisation) {
                System.err.println("Erreur : Impossible de contacter SERVICE-CLIENT ou d'enregistrer les données.");
                exceptionInitialisation.printStackTrace();
            }
        };
    }
}