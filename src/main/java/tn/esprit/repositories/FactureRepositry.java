package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Facture;

@Repository

public interface FactureRepositry extends CrudRepository<Facture, Long> {
}
