package tn.esprit.spring.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.EquipementRepository;
import tn.esprit.spring.repository.VehiculeRepository;
import tn.esprit.spring.service.Interface.IVehiculeService;

import java.math.BigDecimal;
import java.util.List;


@Service
@AllArgsConstructor
public class VehiculeServiceIMPL implements IVehiculeService {

    VehiculeRepository vehiculeRepository;
    EquipementRepository equipementRepository;

    /*private final VehiculeRepository repository;
    private final VehiculeValidatorServiceIMPL validator;
    private final JournalisationServiceIMPL journalisation;

    public VehiculeServiceIMPL(
            VehiculeRepository repository,
            VehiculeValidatorServiceIMPL validator,
            JournalisationServiceIMPL journalisation) {

        this.repository = repository;
        this.validator = validator;
        this.journalisation = journalisation;
    }

    public Vehicule ajouter(Vehicule vehicule) {

        // Validation
        validator.valider(vehicule);

        // Journalisation
        journalisation.enregistrer("Ajout du véhicule");

        // Enregistrement dans la base de données
        return repository.save(vehicule);
    } */


    @Override
    public List<Vehicule> vehiculeMarque(String mat, String marque, CategorieVehicule cv) {
        return List.of();
    }

    @Override
    public List<Vehicule> tarifCroissantParMarque(String marque) {
        return vehiculeRepository.findByMarqueOrderByTarifJournalierAsc(marque);
    }


    @Override
    public List<Vehicule> vehiculesParMarqueEtTarif(String marque, BigDecimal tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierGreaterThan(marque, tarif);
    }



    @Override
    public List<Vehicule> vehiculesParMarqueOuModele(String marque, String modele) {
        return vehiculeRepository.findByMarqueOrModele(marque, modele);
    }


    @Override
    public List<Vehicule> vehiculesParMarques(List<String> marques) {
        return vehiculeRepository.findByMarqueIn(marques);
    }


    @Override
    public List<Vehicule> vehiculesSaufMarques(List<String> marques) {
        return vehiculeRepository.findByMarqueNotIn(marques);
    }

    @Override
    public List<Vehicule> vehiculesParStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> vehiculesDisponiblesCroissant() {
        return vehiculeRepository.findByStatutOrderByTarifJournalierAsc(
                StatutVehicule.DISPONIBLE);
    }

    @Override
    public List<Vehicule> vehiculesParAgence(Agence agence) {
        return vehiculeRepository.findByAgence(agence);
    }


    @Override
    public List<Vehicule> vehiculesParVilleAgence(String ville) {
        return vehiculeRepository.findByAgence_Ville(ville);
    }


    @Override
    public List<Vehicule> vehiculesParNomAgence(String nom) {
        return vehiculeRepository.findByAgence_NomContaining(nom);
    }


    @Override
    public List<Vehicule> vehiculesParAgenceEtMarque(Agence agence, String marque) {
        return vehiculeRepository.findByAgenceAndMarque(agence, marque);
    }


    @Override
    public List<Vehicule> vehiculesSansAgence() {
        return vehiculeRepository.findByAgenceIsNull();
    }


    @Override
    public List<Vehicule> vehiculesAvecAgence() {
        return vehiculeRepository.findByAgenceIsNotNull();
    }

    @Override
    public long compterVehiculesParAgence(Agence agence) {
        return vehiculeRepository.countByAgence(agence);
    }


    @Override
    public boolean agencePossedeVehicules(Agence agence) {
        return vehiculeRepository.existsByAgence(agence);
    }

    @Override
    public List<Vehicule> tarifVehiculeEntre(BigDecimal min, BigDecimal max) {
        return vehiculeRepository.findByTarifJournalierBetween(min,max);
    }

    @Override
    public List<Vehicule> tarifVehiculeAsc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierAsc();
    }

    @Override
    public List<Vehicule> tarifVehiculeDesc() {
        return vehiculeRepository.findAllByOrderByTarifJournalierDesc();
    }

    @Override
    public List<Vehicule> tarifVehiculeMoreEqual(BigDecimal tarifJournalier) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarifJournalier);
    }

    @Override
    public List<Vehicule> tarifVehiculeMoins(BigDecimal tarifJournalier) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarifJournalier);
    }

    @Override
    public List<Vehicule> tarifVehicule(BigDecimal tarifJournalier) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarifJournalier);
    }

    @Override
    public Long conterVehicule(String marque) {
        return vehiculeRepository.countByMarque(marque);
    }

    @Override
    public Boolean vehiculeExist(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }

    @Override
    public List<Vehicule> getModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    AgenceRepository agenceRepository;


    @Override
    public List<Vehicule> getMarqueSansCasse(String marque) {
        return vehiculeRepository.findByMarqueIgnoreCase(marque);
    }

    @Override
    public List<Vehicule> getLastValeurMarque(String valeur) {
        return vehiculeRepository.findByMarqueEndingWith(valeur);
    }

    @Override
    public List<Vehicule> getValeurMarque(String val) {
        return vehiculeRepository.findByMarqueStartingWith(val);
    }

    @Override
    public List<Vehicule> getMarque(String mot) {
        return vehiculeRepository.findByMarqueContaining(mot);
    }

    @Override
    public List<Vehicule> getByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    @Transactional
    @Override
    public Vehicule affecterVehiculeAgence(Long idAgence, Long idVehicule) {
        // Données
        Agence agence = agenceRepository.findById(idAgence).orElse(null);
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);

        // Affectation
        assert vehicule != null;
        vehicule.setAgence(agence);

        // sauvgarde
        return vehiculeRepository.save(vehicule);
    }


    @Transactional
    @Override
    public Vehicule desaffecterEquipementVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);

        vehicule.getEquipements().remove(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Transactional
    @Override
    public Vehicule affecterVehiculeEquipement(Long idVehicule, Long idEquipement) {
       Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
       Equipement equipement = equipementRepository.findById(idEquipement).orElse(null);

       assert vehicule != null;

       vehicule.getEquipements().add(equipement);


        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule creer(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule obtenirParId(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> listerTous() {
        return (List<Vehicule>)  vehiculeRepository.findAll();
    }

    @Override
    public Vehicule mettreAJour(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void supprimer(Long id) {
vehiculeRepository.deleteById(id);
    }
}
