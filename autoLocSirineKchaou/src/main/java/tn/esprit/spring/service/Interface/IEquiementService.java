package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.Equipement;

import java.util.List;

public interface IEquiementService {

    Equipement creer(Equipement equipement);

    Equipement obtenirParId(Long id);

    List<Equipement> listerTous();

    Equipement mettreAJour(Equipement equipement);

    void supprimer(Long id);
}
