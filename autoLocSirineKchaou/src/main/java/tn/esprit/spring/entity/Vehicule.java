package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrément
    @Column(name = "id")
    private Long id;
    private long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    private StatutVehicule statut;

   @JsonIgnore
    @ManyToOne
    private Agence agence;

    @JsonIgnore
    @ManyToMany
    private List<Equipement> equipements;


    @JsonIgnore
    @OneToMany(mappedBy = "vehicule")
    List<Reservation> reservations;
}

