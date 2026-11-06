package tn.esprit.spring.service.Impl;

import tn.esprit.spring.service.Interface.IStrategieTarificationService;

import java.util.Map;

public class TarificationServiceIMPL {

    private final Map<String, IStrategieTarificationService> strategies;

    public TarificationServiceIMPL(
            Map<String, IStrategieTarificationService> strategies) {

        this.strategies = strategies;
    }

    public double calculer(
            String type,
            double tarifJournalier,
            int jours) {

        if (jours <= 0) {
            throw new IllegalArgumentException(
                    "Le nombre de jours doit être positif"
            );
        }

        IStrategieTarificationService strategie = strategies.get(type);

        if (strategie == null) {
            throw new IllegalArgumentException(
                    "Type de tarification inconnu : " + type
            );
        }

        return strategie.calculer(tarifJournalier, jours);
    }


}
