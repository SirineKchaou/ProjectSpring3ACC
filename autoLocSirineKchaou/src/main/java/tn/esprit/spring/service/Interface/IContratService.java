package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.Contrat;

import java.util.List;

public interface IContratService {
    Contrat creer(Contrat contrat);

    Contrat obtenirParId(Long id);

    List<Contrat> listerTous();

    Contrat mettreAJour(Contrat contrat);

    void supprimer(Long id);
}
