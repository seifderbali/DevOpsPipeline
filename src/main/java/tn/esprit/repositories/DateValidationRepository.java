package tn.esprit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.DateValidation;

@Repository

public interface DateValidationRepository  extends CrudRepository<DateValidation, Long> {
}
