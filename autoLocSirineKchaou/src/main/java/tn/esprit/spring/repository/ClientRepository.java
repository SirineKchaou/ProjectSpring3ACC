package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {



    @Query(value = "SELECT c FROM Client c " + "JOIN c.reservations r " + "JOIN r.vehicule v " + "WHERE c.nom = :nom " + "AND c.prenom = :prenom " + "AND v.marque = :marque " + "AND v.categorie = :categorie ")
    List<Client> getClientVehicule(   @Param("nom") String nom,
                                                                                                  @Param("prenom") String prenom,
                                                                                                  @Param("marque") String marque,
                                                                                                  @Param("categorie") CategorieVehicule categorie);




    List<Client> findByNomAndPrenomAndReservationsVehiculeMarqueAndReservationsVehiculeCategorie(String nom, String prenom, String marque, CategorieVehicule categorie);

}
