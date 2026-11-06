package tn.esprit.spring.service.Impl;


import tn.esprit.spring.entity.Vehicule;

import java.math.BigDecimal;


public class VehiculeValidatorServiceIMPL {

    public void valider(Vehicule vehicule) {

        if (vehicule.getTarifJournalier().compareTo(BigDecimal.ZERO) <= 0)  {
            throw new IllegalArgumentException(
                    "Le tarif doit être positif"
            );
        }
    }
}
