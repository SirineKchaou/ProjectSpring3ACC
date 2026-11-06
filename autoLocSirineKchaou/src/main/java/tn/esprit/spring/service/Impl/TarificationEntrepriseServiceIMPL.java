package tn.esprit.spring.service.Impl;

import tn.esprit.spring.service.Interface.IStrategieTarificationService;

public class TarificationEntrepriseServiceIMPL implements IStrategieTarificationService {
    @Override
    public double calculer(double tarifJournalier, int jours) {

        return tarifJournalier * jours * 0.85;
    }
}
