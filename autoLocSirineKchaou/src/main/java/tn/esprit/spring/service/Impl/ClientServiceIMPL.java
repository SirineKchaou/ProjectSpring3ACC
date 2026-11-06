package tn.esprit.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Reservation;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.ReservationRepository;
import tn.esprit.spring.service.Interface.IClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceIMPL implements IClientService {

    ClientRepository clientRepository;
    ReservationRepository reservationRepository;

    @Override
    public List<Client> getByNomPrenomMarqueCategorieVehicule(String nom, String prenom, String marque, CategorieVehicule cv) {
        return clientRepository.getClientVehicule(nom,prenom,marque,cv);
    }

    @Override
    public Client ajouterClientReservation(Client c) {
        clientRepository.save(c);
        for(Reservation reservation : c.getReservations())
        {
            reservation.setClient(c);
            reservationRepository.save(reservation);

        }
        return c;
    }

    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client obtenirParId(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> listerTous() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client mettreAJour(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void supprimer(Long id) {
        clientRepository.deleteById(id);
    }
}
