package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "projetInvestissment")
public class ProjetInvestissment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="CodeProjet")
    String CodeProjet;
    @Column(name="intituleProjet")
    String intituleProjet;
    @Column(name="descriptionSomaire")
    String descriptionSomaire;
    @Column(name="categorie")
    String categorie;
    @Column(name="classification")
    String classification;
    @Column(name="natureBesoin")
    String natureBesoin;
    @Column(name="type")
    String type;
    @Column(name="quantite")
    long quantite;
    @Column(name="prixUnitaireTTC")
    long prixUnitaireTTC;
    @Column(name="UserId")
    Long userId;

    @OneToOne
   // @JsonIgnore
    Budget budget;

/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy="projetInvestissment")
    Set<ComiteTechnique> ComiteTechniques;

*/
}

