package tn.esprit.spring.service.Impl;


import org.springframework.stereotype.Service;

@Service
public class JournalisationServiceIMPL {

    public void enregistrer(String message) {
        System.out.println(message);
    }

}
