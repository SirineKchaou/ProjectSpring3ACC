package tn.esprit.spring.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.service.Interface.IEmployeService;

import java.util.List;

@Tag(name = "Gestion des Employee")
@RestController
@AllArgsConstructor
@RequestMapping("/EmployeController")
public class EmployeController {
    IEmployeService iEmployeService;

    @PutMapping("/Affect/{idAgence}/{idEmploye}")
    public Employe affecterEmployeAgence(@PathVariable  Long idAgence,@PathVariable Long idEmploye) {
        return iEmployeService.affecterEmployeAgence(idAgence, idEmploye);
    }

    @Operation(description = "Ajouter les Employées")
    @PostMapping("/Add")
    public Employe creer(@RequestBody Employe employe) {
        return iEmployeService.creer(employe);
    }

    @Operation(description = "Rechercher les Employées")
    @GetMapping("/SearchByID/{id}")
    public Employe obtenirParId(@PathVariable Long id) {
        return iEmployeService.obtenirParId(id);
    }

    @Operation(description = "Lister les Employées")
    @GetMapping("/ListerTous")
    public List<Employe> listerTous() {
        return iEmployeService.listerTous();
    }

    @Operation(description = "Modifier les Employées")
    @PutMapping("/Update")
    public Employe mettreAJour(@RequestBody Employe employe) {
        return iEmployeService.mettreAJour(employe);
    }

    @Operation(description = "Supprimer les Employées")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iEmployeService.supprimer(id);
    }
}

