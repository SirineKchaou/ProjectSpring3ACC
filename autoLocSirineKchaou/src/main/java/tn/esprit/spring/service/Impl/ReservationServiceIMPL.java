package tn.esprit.spring.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.repository.VehiculeRepository;
import tn.esprit.spring.service.Interface.IReservationService;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class ReservationServiceIMPL implements IReservationService {

    ReservationRepository reservationRepository;
    VehiculeRepository vehiculeRepository;

    @Override
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES, initialDelay = 1)
    public void reservationExpire() {

        for (Reservation reservation : reservationRepository.getReservationExpire(LocalDate.now(), StatutReservation.CONFIRMEE)){

            reservation.setStatut(StatutReservation.TERMINEE);
            reservationRepository.save(reservation);
        }

    }

    @Transactional
    @Override
    public Reservation desaffecterReservationVehicule(Long idReservation) {
       Reservation reservation = reservationRepository.findById(idReservation).orElse(null);

       reservation.setVehicule(null);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation ajouterContartReservation(Reservation r) {
        return reservationRepository.save(r);


    }

    @Override
    public Reservation creer(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation obtenirParId(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> listerTous() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation mettreAJour(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void supprimer(Long id) {
reservationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void affecterVehiculeReservation(String matricule, String marque, CategorieVehicule cv, LocalDate dateDebut, LocalDate dateFin) {
        List<Reservation> reservations = reservationRepository.findByDateDebutGreaterThanAndDateFinLessThan(dateDebut,dateFin);
        Vehicule vehicule = vehiculeRepository.findByImmatriculationAndMarqueAndCategorie(matricule,marque,cv);

        for (Reservation reservation : reservations) {
            reservation.setVehicule(vehicule);
            reservationRepository.save(reservation);
        }
        return;

    }

    @Override
    public Reservation listReservation(LocalDate datedebut, LocalDate detfin) {
        return null;
    }
}
