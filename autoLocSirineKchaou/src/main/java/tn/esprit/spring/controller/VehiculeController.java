package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.StatutVehicule;
import tn.esprit.spring.entity.Vehicule;
import tn.esprit.spring.service.Interface.IVehiculeService;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Gestion des véhicules")
@RestController
@AllArgsConstructor
@RequestMapping("/VehiculeController")
public class VehiculeController {
    IVehiculeService iVehiculeService;



    @GetMapping("/vehiculesParMarqueEtTarif")
    public List<Vehicule> vehiculesParMarqueEtTarif(
            @RequestParam String marque,
            @RequestParam BigDecimal tarif) {
        return iVehiculeService.vehiculesParMarqueEtTarif(marque, tarif);
    }


    @GetMapping("/tarifVehiculeEntre")
    public List<Vehicule> tarifVehiculeEntre(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return iVehiculeService.tarifVehiculeEntre(min, max);
    }


    @GetMapping("/vehiculesParAgenceEtMarque")
    public List<Vehicule> vehiculesParAgenceEtMarque(
            @RequestParam Long idAgence,
            @RequestParam String marque) {
        Agence agence = new Agence();
        agence.setIdAgence(idAgence);
        return iVehiculeService.vehiculesParAgenceEtMarque(agence, marque);
    }


    @GetMapping("/vehiculesSansAgence")
    public List<Vehicule> vehiculesSansAgence() {
        return iVehiculeService.vehiculesSansAgence();
    }


    @GetMapping("/vehiculesAvecAgence")
    public List<Vehicule> vehiculesAvecAgence() {
        return iVehiculeService.vehiculesAvecAgence();
    }


    @GetMapping("/tarifVehiculeAsc")
    public List<Vehicule> tarifVehiculeAsc() {
        return iVehiculeService.tarifVehiculeAsc();
    }

    @GetMapping("/tarifVehiculeDesc")
    public List<Vehicule> tarifVehiculeDesc() {
        return iVehiculeService.tarifVehiculeDesc();
    }


    @GetMapping("/tarifCroissantParMarque")
    public List<Vehicule> tarifCroissantParMarque(
            @RequestParam String marque) {
        return iVehiculeService.tarifCroissantParMarque(marque);
    }


    @GetMapping("/agencePossedeVehicules")
    public boolean agencePossedeVehicules(@RequestParam Long idAgence) {
        Agence agence = new Agence();
        agence.setIdAgence(idAgence);
        return iVehiculeService.agencePossedeVehicules(agence);
    }


    @GetMapping("/vehiculesParVilleAgence")
    public List<Vehicule> vehiculesParVilleAgence(
            @RequestParam String ville) {
        return iVehiculeService.vehiculesParVilleAgence(ville);
    }


    @GetMapping("/vehiculesParMarqueOuModele")
    public List<Vehicule> vehiculesParMarqueOuModele(
            @RequestParam String marque,
            @RequestParam String modele) {
        return iVehiculeService.vehiculesParMarqueOuModele(marque, modele);
    }


    @GetMapping("/compterVehiculesParAgence")
    public long compterVehiculesParAgence(@RequestParam Long idAgence) {
        Agence agence = new Agence();
        agence.setIdAgence(idAgence);
        return iVehiculeService.compterVehiculesParAgence(agence);
    }


    @GetMapping("/vehiculesParNomAgence")
    public List<Vehicule> vehiculesParNomAgence(
            @RequestParam String nom) {
        return iVehiculeService.vehiculesParNomAgence(nom);
    }


    @GetMapping("/vehiculesParMarques")
    public List<Vehicule> vehiculesParMarques(
            @RequestParam List<String> marques) {
        return iVehiculeService.vehiculesParMarques(marques);
    }


    @GetMapping("/vehiculesSaufMarques")
    public List<Vehicule> vehiculesSaufMarques(
            @RequestParam List<String> marques) {
        return iVehiculeService.vehiculesSaufMarques(marques);
    }


    @GetMapping("/vehiculesParStatut")
    public List<Vehicule> vehiculesParStatut(
            @RequestParam StatutVehicule statut) {
        return iVehiculeService.vehiculesParStatut(statut);
    }


    @GetMapping("/vehiculesDisponiblesCroissant")
    public List<Vehicule> vehiculesDisponiblesCroissant() {
        return iVehiculeService.vehiculesDisponiblesCroissant();
    }

    @GetMapping("/vehiculesParAgence")
    public List<Vehicule> vehiculesParAgence(@RequestParam Long idAgence) {
        Agence agence = new Agence();
        agence.setIdAgence(idAgence);
        return iVehiculeService.vehiculesParAgence(agence);
    }


    @GetMapping("/VehiculeMoreEqual/{tarifJournalier}")
    public List<Vehicule> tarifVehiculeMoreEqual(@PathVariable BigDecimal tarifJournalier) {
        return iVehiculeService.tarifVehiculeMoreEqual(tarifJournalier);
    }

    @GetMapping("/VehiculeLess/{tarifJournalier}")
    public List<Vehicule> tarifVehiculeMoins(@PathVariable BigDecimal tarifJournalier) {
        return iVehiculeService.tarifVehiculeMoins(tarifJournalier);
    }

    @GetMapping("/Vehicule/{tarifJournalier}")
    public List<Vehicule> tarifVehicule(@PathVariable BigDecimal tarifJournalier) {
        return iVehiculeService.tarifVehicule(tarifJournalier);
    }

    @GetMapping("/VehiculeMarque/{marque}")
    public Long conterVehicule(@PathVariable String marque) {
        return iVehiculeService.conterVehicule(marque);
    }

    @GetMapping("/listsVeh/{immatriculation}")
    public Boolean vehiculeExist(@PathVariable String immatriculation) {
        return iVehiculeService.vehiculeExist(immatriculation);
    }

    @GetMapping("/listVeh/{modele}")
    public List<Vehicule> getModele(@PathVariable String modele) {
        return iVehiculeService.getModele(modele);
    }

    @GetMapping("/listVe/{marque}")
    public List<Vehicule> getMarqueSansCasse(@PathVariable String marque) {
        return iVehiculeService.getMarqueSansCasse(marque);
    }

    @GetMapping("/listValeurEnd/{valeur}")
    public List<Vehicule> getLastValeurMarque(@PathVariable String valeur) {
        return iVehiculeService.getLastValeurMarque(valeur);
    }

    @GetMapping("/listVal/{val}")
    public List<Vehicule> getValeurMarque(@PathVariable String val) {
        return iVehiculeService.getValeurMarque(val);
    }

    @GetMapping("/listV/{mot}")
    public List<Vehicule> getMarque(@PathVariable String mot) {
        return iVehiculeService.getMarque(mot);
    }

    @GetMapping("/listVehicules/{marque}")
    public List<Vehicule> getByMarque(@PathVariable String marque) {
        return iVehiculeService.getByMarque(marque);
    }

    @PutMapping("/Affect/{idAgence}/{idVehicule}")
    public Vehicule affecterVehiculeAgence(@PathVariable  Long idAgence, @PathVariable Long idVehicule) {
        return iVehiculeService.affecterVehiculeAgence(idAgence, idVehicule);
    }

    @PutMapping("/desaffectEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipementVehicule(@PathVariable  Long idVehicule,@PathVariable Long idEquipement) {
        return iVehiculeService.desaffecterEquipementVehicule(idVehicule, idEquipement);
    }

    @PutMapping("/affect/{idVehicule}/{idEquipement}")
    public Vehicule affecterVehiculeEquipement(Long idVehicule, Long idEquipement) {
        return iVehiculeService.affecterVehiculeEquipement(idVehicule, idEquipement);
    }

    @Operation(description = "Ajouter les véhicules")
    @PostMapping("/Add")
    public Vehicule creer(@RequestBody Vehicule vehicule) {
        return iVehiculeService.creer(vehicule);
    }

    @Operation(description = "Rechercher les véhicules")
    @GetMapping("/SearchByID/{id}")
    public Vehicule obtenirParId(@PathVariable Long id) {
        return iVehiculeService.obtenirParId(id);
    }

    @Operation(description = "Lister les véhicules")
    @GetMapping("/ListerTous")
    public List<Vehicule> listerTous() {
        return iVehiculeService.listerTous();
    }

    @Operation(description = "Modifier les véhicules")
    @PutMapping("/Update")
    public Vehicule mettreAJour(@RequestBody Vehicule vehicule) {
        return iVehiculeService.mettreAJour(vehicule);
    }

    @Operation(description = "Supprimer les véhicules")
    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iVehiculeService.supprimer(id);
    }
}
