package ma.project.tp18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Classe principale du serveur de découverte Eureka.
 * Ce serveur centralise l'enregistrement et la découverte des microservices.
 * Les autres services s'enregistrent automatiquement auprès de ce serveur.
 * 
 * <p>Architecture des microservices:</p>
 * <ul>
 *   <li>SERVICE-CLIENT - Gestion des clients (port 8088)</li>
 *   <li>SERVICE-VOITURE - Gestion des voitures (port 8089)</li>
 *   <li>GATEWAY - Point d'entrée unique (port 8888)</li>
 * </ul>
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@SpringBootApplication
@EnableEurekaServer
public class Tp18Application {

    /**
     * Point d'entrée principal du serveur Eureka.
     * Initialise le registre de services et démarre le tableau de bord Eureka.
     * Le serveur est accessible sur http://localhost:8761
     * 
     * @param argumentsApplication Les arguments passés en ligne de commande
     */
    public static void main(String[] argumentsApplication) {
        SpringApplication.run(Tp18Application.class, argumentsApplication);
    }
}
