package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.Agence;


import java.util.List;

public interface IAgenceService {

    Agence creer(Agence agence);

    Agence obtenirParId(Long id);

    List<Agence> listerTous();

    Agence mettreAJour(Agence agence);

    void supprimer(Long id);


}
