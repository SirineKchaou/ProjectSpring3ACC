package tn.esprit.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.service.Interface.IAgenceService;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceIMPL implements IAgenceService {

    AgenceRepository agenceRepository;



    @Override
    public Agence creer(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence obtenirParId(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Agence> listerTous() {
        return (List<Agence>) agenceRepository.findAll();
    }

    @Override
    public Agence mettreAJour(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void supprimer(Long id) {

        agenceRepository.deleteById(id);
    }
}
