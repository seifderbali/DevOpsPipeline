package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comiteTechnique")
public class ComiteTechnique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="annee")
    String annee;
    @Column(name="statutProjet")
    String statutProjet;
    @Column(name="axeDemande")
    String axeDemande;
    @Column(name="typeDemande")
    String typeDemande;
    @Column(name="observationComite")
    String observationComite;
    @Column(name="UserId")
    Long userId;

    @OneToOne
    // @JsonIgnore
    DateValidation dateValidation;

    @ManyToOne
   //@JsonIgnore
    Budget budget  ;
}
