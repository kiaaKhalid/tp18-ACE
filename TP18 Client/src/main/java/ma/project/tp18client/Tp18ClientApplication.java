package ma.project.tp18client;

import ma.project.tp18client.entities.Client;
import ma.project.tp18client.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Classe principale de l'application microservice Client.
 * Cette application gère les opérations CRUD pour les entités Client.
 * Elle s'enregistre automatiquement auprès du serveur Eureka pour la découverte de services.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Tp18ClientApplication {

    /**
     * Point d'entrée principal de l'application Spring Boot.
     * Initialise le contexte Spring et démarre le serveur embarqué.
     * 
     * @param arguments Les arguments passés en ligne de commande
     */
    public static void main(String[] arguments) {
        SpringApplication.run(Tp18ClientApplication.class, arguments);
    }

    /**
     * Bean d'initialisation de la base de données H2.
     * Crée des données de test pour les clients lors du démarrage de l'application.
     * 
     * @param repositoryClient Le repository permettant l'accès aux données Client
     * @return Un CommandLineRunner qui exécute l'initialisation des données
     */
    @Bean
    CommandLineRunner chargerDonneesInitiales(ClientRepository repositoryClient) {
        return parametres -> {
            // Insertion des clients de démonstration dans la base de données
            repositoryClient.save(new Client(null, "Hammam ELKENTAOUI", 23f));
            repositoryClient.save(new Client(null, "Abdellah ELKENTAOUI", 22f));
            repositoryClient.save(new Client(null, "Aamer ELKENTAOUI", 22f));
        };
    }
}
