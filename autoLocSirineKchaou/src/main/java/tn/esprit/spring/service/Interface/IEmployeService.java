package tn.esprit.spring.service.Interface;

import tn.esprit.spring.entity.Employe;

import java.util.List;

public interface IEmployeService {

    Employe creer(Employe employee);

    Employe obtenirParId(Long id);

    List<Employe> listerTous();

    Employe mettreAJour(Employe employee);

    void supprimer(Long id);

    Employe affecterEmployeAgence(Long idAgence, Long idEmploye);
}
