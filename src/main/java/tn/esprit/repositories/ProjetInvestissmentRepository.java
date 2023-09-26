package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.ProjetInvestissment;

import java.util.List;

@Repository

public interface ProjetInvestissmentRepository extends CrudRepository<ProjetInvestissment, Long> {
    @Query("select p from ProjetInvestissment p where p.CodeProjet like %?1% or p.intituleProjet like %?1% or p.descriptionSomaire like %?1% or p.categorie like %?1% or p.classification like %?1% or p.natureBesoin like %?1% or p.type like %?1% or p.quantite like %?1% or p.prixUnitaireTTC like %?1%")
    List<ProjetInvestissment> search(String keyword);
/*
    @Query("select p.budgetInvestissement from ProjetInvestissment p where p.id =:#{#id} ")
    Budget findBudget(long id);


 */

    @Query("select b from ProjetInvestissment b where b.budget.id=:#{#id} ")
    ProjetInvestissment findProjectInvesst(long id);


}
