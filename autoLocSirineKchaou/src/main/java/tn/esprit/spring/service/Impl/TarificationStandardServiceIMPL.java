package tn.esprit.spring.service.Impl;

import tn.esprit.spring.service.Interface.IStrategieTarificationService;

public class TarificationStandardServiceIMPL implements IStrategieTarificationService {
    @Override
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours;
    }
}
