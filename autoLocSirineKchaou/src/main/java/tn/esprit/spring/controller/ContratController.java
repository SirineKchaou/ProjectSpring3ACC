package tn.esprit.spring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.service.Interface.IContratService;

import java.util.List;

@Tag(name = "Gestion des contrats")
@RestController
@AllArgsConstructor
@RequestMapping("/ContratController")
public class ContratController {
    IContratService iContratService;

    @Operation(description = "Ajouter les contrats")
    @PostMapping("/Add")
    public Contrat creer(@RequestBody Contrat contrat) {
        return iContratService.creer(contrat);
    }

    @Operation(description = "Rechercher les contrats")
    @GetMapping("/SearchByID/{id}")
    public Contrat obtenirParId(@PathVariable Long id) {
        return iContratService.obtenirParId(id);
    }

    @Operation(description = "Lister les contrats")
    @GetMapping("/ListerTous")
    public List<Contrat> listerTous() {
        return iContratService.listerTous();
    }

    @Operation(description = "Modifier les contrats")
    @PutMapping("/Update")
    public Contrat mettreAJour(@RequestBody Contrat contrat) {
        return iContratService.mettreAJour(contrat);
    }

    @Operation(description = "Supprimer les contrats")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iContratService.supprimer(id);
    }
}
