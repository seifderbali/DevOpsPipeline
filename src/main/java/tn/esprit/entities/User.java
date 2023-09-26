package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;
    @Column(name="name")
    String name;
    @Column(name="lastname")
    String lastname;
    @Column(name="birthdate")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    Date birthdate;
    @Column(name="Mail")
    String Mail;
    @Column(name="password")
    String password;
    @Column(name="placeOfBirth")
    String placeOfBirth;
    @Column(name="address")
    String address;
    @Column(name="tel")
    String tel;
    @Column(name="sexe")
    Sexe sexe;
    @Column(name="direction")
    String direction;
    @Column(name="role")
    Role role;
    @Column(name="UserId")
    Long userId;
    @Transient
    String token;

    @ManyToOne
    private EntiteSI entiteSI;
/*
    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString(); // generate a random UUID string as the ID
    }

 */

}
