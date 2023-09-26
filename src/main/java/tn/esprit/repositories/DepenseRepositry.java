package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Depense;

import java.util.List;

@Repository

public interface DepenseRepositry extends CrudRepository<Depense, Long> {

    @Query("select d from Depense d where d.objetFacture like %?1% or d.numFacture like %?1% or d.devise like %?1% or d.montantFactureTND like %?1% or d.description like %?1% or d.statutFacture like %?1%")
    List<Depense> search(String keyword);
}
