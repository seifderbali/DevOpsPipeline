package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.EntiteSI;
import tn.esprit.entities.User;

import java.util.List;

@Repository
public interface EntiteSIRepository extends CrudRepository<EntiteSI, Long> {

    @Query("select e from EntiteSI e where e.name like %?1% ")
    List<EntiteSI> search(String keyword);
    @Query("select (e) from EntiteSI e where e.name=:#{#name}")
    EntiteSI finfByName(@Param("name") String name );
    @Query("select sum(e.BudgetN) from Budget e where e.entiteSI.id=:#{#id}")
    String findBudget(@Param("id") long id );
    @Query("select sum(e.BudgetN) from Budget e ")
    String allbudget();
}
