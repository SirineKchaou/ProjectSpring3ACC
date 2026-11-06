package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.CategorieVehicule;
import tn.esprit.spring.entity.Client;

import java.util.List;

public interface IClientService {
    Client creer(Client client);

    Client obtenirParId(Long id);

    List<Client> listerTous();

    Client mettreAJour(Client client);

    void supprimer(Long id);

    Client ajouterClientReservation(Client c);

    List<Client> getByNomPrenomMarqueCategorieVehicule(String nom, String prenom, String marque, CategorieVehicule cv);
}
