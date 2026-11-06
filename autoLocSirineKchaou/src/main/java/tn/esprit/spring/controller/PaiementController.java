package tn.esprit.spring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Paiement;
import tn.esprit.spring.service.Interface.IPaiementService;

import java.util.List;

@Tag(name = "Gestion des Paiements")
@RestController
@AllArgsConstructor
@RequestMapping("/PaiementController")
public class PaiementController {
    IPaiementService iPaiementService;

    @Operation(description = "Ajouter les Paiements")
    @PostMapping("/Add")
    public Paiement creer(@RequestBody Paiement paiement) {
        return iPaiementService.creer(paiement);
    }

    @Operation(description = "Rechercher les Paiements")
    @GetMapping("/SearchByID/{id}")
    public Paiement obtenirParId(@PathVariable Long id) {
        return iPaiementService.obtenirParId(id);
    }

    @Operation(description = "Lister les Paiements")
    @GetMapping("/ListerTous")
    public List<Paiement> listerTous() {
        return iPaiementService.listerTous();
    }

    @Operation(description = "Modifier les Paiements")
    @PutMapping("/Update")
    public Paiement mettreAJour(@RequestBody Paiement paiement) {
        return iPaiementService.mettreAJour(paiement);
    }

    @Operation(description = "Supprimer les Paiements")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iPaiementService.supprimer(id);
    }
}
