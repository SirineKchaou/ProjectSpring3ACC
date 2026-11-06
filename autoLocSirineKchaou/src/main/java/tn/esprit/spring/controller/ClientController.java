package tn.esprit.spring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.service.Interface.IClientService;

import java.util.List;

@Tag(name = "Gestion des clients")
@RestController
@AllArgsConstructor
@RequestMapping("/ClientController")
public class ClientController {
    IClientService iClientService;



    @GetMapping("/ListClientsJPQL/{nom}/{prenom}/{marque}/{cv}")
    public List<Client> getByNomPrenomMarqueCategorieVehicule(@PathVariable String nom, @PathVariable String prenom,@PathVariable String marque,@PathVariable CategorieVehicule cv) {
        return iClientService.getByNomPrenomMarqueCategorieVehicule(nom, prenom, marque, cv);
    }

    @PostMapping("/addAffect")
    public Client ajouterClientReservation(@RequestBody  Client c) {
        return iClientService.ajouterClientReservation(c);
    }

    @Operation(description = "Ajouter les clients")
    @PostMapping("/Add")
    public Client creer(@RequestBody Client client) {
        return iClientService.creer(client);
    }

    @Operation(description = "Rechercher les clients")
    @GetMapping("/SearchByID/{id}")
    public Client obtenirParId(@PathVariable Long id) {
        return iClientService.obtenirParId(id);
    }

    @Operation(description = "Lister les clients")
    @GetMapping("/ListerTous")
    public List<Client> listerTous() {
        return iClientService.listerTous();
    }

    @Operation(description = "Modifier les clients")
    @PutMapping("/Update")
    public Client mettreAJour(@RequestBody Client client) {
        return iClientService.mettreAJour(client);
    }

    @Operation(description = "Supprimer les clients")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iClientService.supprimer(id);
    }
}
