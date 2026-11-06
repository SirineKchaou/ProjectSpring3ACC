package tn.esprit.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.EmployeeRepository;
import tn.esprit.spring.service.Interface.IEmployeService;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceIMPL implements IEmployeService {

    EmployeeRepository employeeRepository;
    AgenceRepository agenceRepository;

    @Override
    public Employe creer(Employe employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employe obtenirParId(Long id) {
        //or else null : si il n'existe pas ne le récupoere pas
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> listerTous() {
        return (List<Employe>) employeeRepository.findAll();
    }

    @Override
    public Employe mettreAJour(Employe employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void supprimer(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employe affecterEmployeAgence(Long idAgence, Long idEmploye) {
        // Données
        Agence agence = agenceRepository.findById(idAgence).orElse(null);
        Employe employe = employeeRepository.findById(idEmploye).orElse(null);

        // Affectation
        assert employe != null;
        employe.setAgence(agence);

        // sauvgarde
        return employeeRepository.save(employe);
    }
}
