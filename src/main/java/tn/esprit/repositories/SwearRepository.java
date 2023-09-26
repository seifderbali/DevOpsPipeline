package tn.esprit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.swear_words;

@Repository
public interface SwearRepository extends CrudRepository<swear_words, Long>{

    @Query("select word from swear_words")
    List<String> listSwear();
}