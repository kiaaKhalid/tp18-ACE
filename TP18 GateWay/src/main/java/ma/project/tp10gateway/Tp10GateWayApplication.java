package ma.project.tp10gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Classe principale de l'API Gateway Spring Cloud.
 * Cette passerelle centralise les requêtes entrantes et les route vers les microservices appropriés.
 * Elle utilise Eureka pour la découverte dynamique des services.
 * 
 * <p>Points d'entrée exposés:</p>
 * <ul>
 *   <li>/clients/** - Routé vers SERVICE-CLIENT</li>
 *   <li>/voitures/** - Routé vers SERVICE-VOITURE</li>
 * </ul>
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@SpringBootApplication
public class Tp10GateWayApplication {

    /**
     * Point d'entrée principal de l'API Gateway.
     * Initialise le contexte Spring et démarre le serveur réactif.
     * La gateway est accessible sur http://localhost:8888
     * 
     * @param argumentsDemarrage Les arguments passés en ligne de commande
     */
    public static void main(String[] argumentsDemarrage) {
        SpringApplication.run(Tp10GateWayApplication.class, argumentsDemarrage);
    }

    /**
     * Bean de configuration pour la découverte dynamique des routes.
     * Permet de router automatiquement vers les services enregistrés dans Eureka.
     * Les routes sont générées dynamiquement selon les services disponibles.
     * 
     * @param clientDecouverteReactif Le client réactif pour la découverte des services
     * @param proprietesLocalisation Les propriétés de configuration de la localisation
     * @return Le localisateur de définitions de routes basé sur la découverte
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator configurerRoutesAutomatiques(
            ReactiveDiscoveryClient clientDecouverteReactif, 
            DiscoveryLocatorProperties proprietesLocalisation) {
        return new DiscoveryClientRouteDefinitionLocator(clientDecouverteReactif, proprietesLocalisation);
    }

    /**
     * Bean de configuration des routes statiques vers les microservices.
     * Définit explicitement les chemins et les services de destination.
     * Utilise le load balancer (lb://) pour la répartition de charge.
     * 
     * @param constructeurRoutes Le builder pour construire les routes
     * @return Le localisateur de routes configuré
     */
    @Bean
    RouteLocator configurerRoutesStatiques(RouteLocatorBuilder constructeurRoutes) {
        return constructeurRoutes.routes()
                // Configuration de la route vers le Service de gestion des Clients
                .route("route-service-client", 
                       specificationRoute -> specificationRoute
                               .path("/clients/**")
                               .uri("lb://SERVICE-CLIENT"))

                // Configuration de la route vers le Service de gestion des Voitures
                .route("route-service-voiture", 
                       specificationRoute -> specificationRoute
                               .path("/voitures/**")
                               .uri("lb://SERVICE-VOITURE"))
                .build();
    }
}
