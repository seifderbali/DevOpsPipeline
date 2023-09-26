package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Fournisseur;

import java.util.List;

@Repository

public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
    @Query("select f from Fournisseur f where f.code like %?1% or f.name like %?1% or f.immatFiscal like %?1% or f.mail like %?1% or f.siteWeb like %?1% or f.tel like %?1%")
    List<Fournisseur> search(String keyword);



    @Query("select b.fournisseur from ContatDeMarche b where b.id =:#{#id}")
    Fournisseur findByContrat(long id );

    @Query("select sum(b.montantTTC) from ContatDeMarche b where b.fournisseur.id =:#{#id}")
    String findBudget(long id );
}
