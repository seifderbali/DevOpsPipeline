package tn.esprit.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entiteSI")
public class EntiteSI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="name")
    String name;
    @Column(name="UserId")
    Long userId;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy="entiteSI")
    Set<User> users;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="entiteSI")
    Set<ProjetInvestissment> ProjetInvestissments;
*/
}