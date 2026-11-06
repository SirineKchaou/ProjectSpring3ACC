package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.entity.StatutReservation;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

   // LocalDate current = LocalDate.now();
   // String statutRes =  StatutReservation.CONFIRMEE.name();
   // String status = Status.PENDING.name();

    @Query(value = "SELECT r FROM Reservation r " + "WHERE r.dateFin < :current " + "AND r.statut = :statutRes ")
    List<Reservation> getReservationExpire(@Param("current") LocalDate current, @Param("statutRes") StatutReservation statutRes);

    List<Reservation> findByDateDebutGreaterThanAndDateFinLessThan(
            LocalDate datedebut,
            LocalDate datefin);


}