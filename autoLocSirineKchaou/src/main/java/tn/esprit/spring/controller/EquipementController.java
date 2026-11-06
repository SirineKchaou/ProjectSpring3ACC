package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Equipement;
import tn.esprit.spring.service.Interface.IEquiementService;

import java.util.List;

@Tag(name = "Gestion des Equipements")
@RestController
@AllArgsConstructor
@RequestMapping("/EquipementController")
public class EquipementController {
    IEquiementService iEquiementService;

    @Operation(description = "Ajouter les Equipements")
    @PostMapping("/Add")
    public Equipement creer(@RequestBody Equipement equipement) {
        return iEquiementService.creer(equipement);
    }

    @Operation(description = "Rechercher les Equipements")
    @GetMapping("/SearchByID/{id}")
    public Equipement obtenirParId(@PathVariable Long id) {
        return iEquiementService.obtenirParId(id);
    }

    @Operation(description = "Lister les Equipements")
    @GetMapping("/ListerTous")
    public List<Equipement> listerTous() {
        return iEquiementService.listerTous();
    }

    @Operation(description = "Modifier les Equipements")
    @PutMapping("/Update")
    public Equipement mettreAJour(@RequestBody Equipement equipement) {
        return iEquiementService.mettreAJour(equipement);
    }

    @Operation(description = "Supprimer les Equipements")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iEquiementService.supprimer(id);
    }
}
