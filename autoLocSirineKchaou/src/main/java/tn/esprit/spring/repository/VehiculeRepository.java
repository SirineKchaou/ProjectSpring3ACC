package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.StatutVehicule;
import tn.esprit.spring.entity.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {

    Vehicule findByImmatriculationAndMarqueAndCategorie(String mat, String marque, CategorieVehicule cv);


    List<Vehicule> findByMarque(String m);

    List<Vehicule> findByMarqueContaining(String mot);

    List<Vehicule> findByMarqueStartingWith(String val);

    List<Vehicule> findByMarqueEndingWith(String valeur);

    List<Vehicule> findByMarqueIgnoreCase(String marque);

    List<Vehicule> findByModele(String modele);

    Boolean existsByImmatriculation(String immatriculation);

    Long countByMarque(String marque);

    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarifJournalier);

    List<Vehicule> findByTarifJournalierLessThan(BigDecimal tarifJournalier);

    List<Vehicule> findByTarifJournalierGreaterThanEqual(BigDecimal tarifJournalier);

    List<Vehicule> findByTarifJournalierBetween(
            BigDecimal min,
            BigDecimal max
    );

    List<Vehicule> findAllByOrderByTarifJournalierAsc();

    List<Vehicule> findAllByOrderByTarifJournalierDesc();


    List<Vehicule> findByMarqueOrderByTarifJournalierAsc(String marque);


    List<Vehicule> findByMarqueAndTarifJournalierGreaterThan(
            String marque, BigDecimal tarif);


    List<Vehicule> findByMarqueOrModele(String marque, String modele);


    List<Vehicule> findByMarqueIn(List<String> marques);


    List<Vehicule> findByMarqueNotIn(List<String> marques);


    List<Vehicule> findByStatut(StatutVehicule statut);


    List<Vehicule> findByStatutOrderByTarifJournalierAsc(StatutVehicule statut);


    List<Vehicule> findByAgence(Agence agence);


    List<Vehicule> findByAgence_Ville(String ville);


    List<Vehicule> findByAgence_NomContaining(String nom);


    List<Vehicule> findByAgenceAndMarque(Agence agence, String marque);


    List<Vehicule> findByAgenceIsNull();


    List<Vehicule> findByAgenceIsNotNull();


    long countByAgence(Agence agence);


    boolean existsByAgence(Agence agence);

}
