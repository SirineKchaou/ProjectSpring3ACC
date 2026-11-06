package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrément
    @Column(name = "id")
    private Long id;
    private long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private Boolean valide;

    @JsonIgnore
    @OneToOne(mappedBy = "contrat")
    Reservation reservation;

    @JsonIgnore
    @OneToMany(mappedBy = "contrat")
    List<Paiement> paiements;
}
