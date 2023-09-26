package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.name like %?1% or u.lastname like %?1%")
    List<User> search(String keyword);

    @Query("select (u) from User u where  u.Mail=:#{#mail} and u.password=:#{#mdp}")
    User DoLogin(@Param("mail") String mail, @Param("mdp") String mdp);
    @Query("select (u) from User u where u.id=:#{#id}")
    User findById(@Param("id") String id );

    @Query("delete from User u where u.id=:#{#id}")
    void delete(@Param("id") String id );


    @Query("select u from User u where u.Mail like %?1%")
    User findByMail(String mail);


    @Query("select u from User u where u.id =:#{#id}")
    User findUserById(long id);


}
