package tn.esprit.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Paiement;
import tn.esprit.spring.repository.PaiementRepository;
import tn.esprit.spring.service.Interface.IPaiementService;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceIMPL implements IPaiementService {

    PaiementRepository paiementRepository;

    @Override
    public Paiement creer(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement obtenirParId(Long id) {
        return paiementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> listerTous() {
        return (List<Paiement>) paiementRepository.findAll();
    }

    @Override
    public Paiement mettreAJour(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void supprimer(Long id) {
paiementRepository.deleteById(id);
    }
}
