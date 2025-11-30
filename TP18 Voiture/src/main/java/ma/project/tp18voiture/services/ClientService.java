package ma.project.tp18voiture.services;

import ma.project.tp18voiture.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface Feign Client pour la communication avec le microservice Client.
 * Permet d'effectuer des appels REST vers SERVICE-CLIENT de manière déclarative.
 * La découverte du service se fait automatiquement via Eureka.
 * 
 * @author Développeur Spring Cloud
 * @version 2.0
 * @since 2024
 */
@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {
    
    /**
     * Récupère les informations d'un client par son identifiant.
     * Appel REST GET vers le endpoint /client/{id} du microservice Client.
     * 
     * @param identifiantClient L'identifiant unique du client recherché
     * @return L'objet Client correspondant aux données du microservice
     */
    @GetMapping(path = "/client/{id}")
    Client recupererClientParIdentifiant(@PathVariable("id") Long identifiantClient);
}
