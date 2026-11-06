package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Maintenance;
import tn.esprit.spring.service.Interface.IMaintenanceService;

import java.util.List;

@Tag(name = "Gestion des Maintenances")
@RestController
@AllArgsConstructor
@RequestMapping("/MaintenanceController")
public class MaintenanceController {
    IMaintenanceService iMaintenanceService;

    @PutMapping("/affect/{idVehicule}/{idMaintenance}")
    public Maintenance affecterVehiculeMaintenance(Long idVehicule, Long idMaintenance) {
        return iMaintenanceService.affecterVehiculeMaintenance(idVehicule, idMaintenance);
    }

    @Operation(description = "Ajouter les Maintenances")
    @PostMapping("/Add")
    public Maintenance creer(@RequestBody Maintenance maintenance) {
        return iMaintenanceService.creer(maintenance);
    }

    @Operation(description = "Rechercher les Maintenances")
    @GetMapping("/SearchByID/{id}")
    public Maintenance obtenirParId(@PathVariable Long id) {
        return iMaintenanceService.obtenirParId(id);
    }

    @Operation(description = "Lister les Maintenances")
    @GetMapping("/ListerTous")
    public List<Maintenance> listerTous() {
        return iMaintenanceService.listerTous();
    }

    @Operation(description = "Modifier les Maintenances")
    @PutMapping("/Update")
    public Maintenance mettreAJour(@RequestBody Maintenance maintenance) {
        return iMaintenanceService.mettreAJour(maintenance);
    }

    @Operation(description = "Supprimer les Maintenances")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iMaintenanceService.supprimer(id);
    }
}
