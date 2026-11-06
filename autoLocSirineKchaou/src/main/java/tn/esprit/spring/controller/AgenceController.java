package tn.esprit.spring.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Agence;
import tn.esprit.spring.service.Interface.IAgenceService;

import java.util.List;

@Tag(name = "Gestion des agences")
@RestController
@AllArgsConstructor
@RequestMapping("/AgenceController")
@EnableScheduling
public class AgenceController {
    IAgenceService iAgenceService;

    @PostMapping("/Add")
    public Agence creer(@RequestBody Agence agence) {
        return iAgenceService.creer(agence);
    }

    @GetMapping("/SearchByID/{id}")
    public Agence obtenirParId(@PathVariable Long id) {
        return iAgenceService.obtenirParId(id);
    }

    @GetMapping("/ListerTous")
    public List<Agence> listerTous() {
        return iAgenceService.listerTous();
    }

    @PutMapping("/Update")
    public Agence mettreAJour(@RequestBody Agence agence) {

        return iAgenceService.mettreAJour(agence);
    }

    @DeleteMapping("/Delete/{id}")
    public void supprimer(@PathVariable Long id) {
        iAgenceService.supprimer(id);
    }
}
