package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Paiement;

@Repository
public interface PaiementRepository extends CrudRepository<Paiement, Long> {
}
