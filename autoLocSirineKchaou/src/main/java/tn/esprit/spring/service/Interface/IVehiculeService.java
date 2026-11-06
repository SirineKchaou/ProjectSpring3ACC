package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.StatutVehicule;
import tn.esprit.spring.entity.Vehicule;

import java.math.BigDecimal;
import java.util.List;

public interface IVehiculeService {
    Vehicule creer(Vehicule vehicule);

    Vehicule obtenirParId(Long id);

    List<Vehicule> listerTous();

    Vehicule mettreAJour(Vehicule vehicule);

    void supprimer(Long id);


    Vehicule affecterVehiculeEquipement(Long idVehicule, Long idEquipement);

   Vehicule desaffecterEquipementVehicule(Long idVehicule, Long idEquipement);

    Vehicule affecterVehiculeAgence(Long idAgence, Long idVehicule);

    List<Vehicule> getByMarque(String marque);

    List<Vehicule> getMarque(String mot);

    List<Vehicule> getValeurMarque(String val);

    List<Vehicule> getLastValeurMarque(String valeur);

    List<Vehicule> getMarqueSansCasse(String marque);

    List<Vehicule> getModele(String modele);

    Boolean vehiculeExist(String immatriculation);

    Long conterVehicule(String marque);

    List<Vehicule> tarifVehicule(BigDecimal tarifJournalier);

    List<Vehicule> tarifVehiculeMoins(BigDecimal tarifJournalier);

    List<Vehicule> tarifVehiculeMoreEqual(BigDecimal tarifJournalier);

    List<Vehicule> tarifVehiculeEntre(BigDecimal min, BigDecimal max);

    List<Vehicule> tarifVehiculeAsc();

    List<Vehicule> tarifVehiculeDesc();

    List<Vehicule> tarifCroissantParMarque(String marque);


    List<Vehicule> vehiculesParMarqueEtTarif(String marque, BigDecimal tarif);

    List<Vehicule> vehiculesParMarqueOuModele(String marque, String modele);


    List<Vehicule> vehiculesParMarques(List<String> marques);


    List<Vehicule> vehiculesSaufMarques(List<String> marques);


    List<Vehicule> vehiculesParStatut(StatutVehicule statut);


    List<Vehicule> vehiculesDisponiblesCroissant();

    List<Vehicule> vehiculesParAgence(Agence agence);

    List<Vehicule> vehiculesParVilleAgence(String ville);


    List<Vehicule> vehiculesParNomAgence(String nom);


    List<Vehicule> vehiculesParAgenceEtMarque(Agence agence, String marque);


    List<Vehicule> vehiculesSansAgence();

    List<Vehicule> vehiculesAvecAgence();

    List<Vehicule> vehiculeMarque(String mat, String marque, CategorieVehicule cv);

    long compterVehiculesParAgence(Agence agence);

    boolean agencePossedeVehicules(Agence agence);

}
