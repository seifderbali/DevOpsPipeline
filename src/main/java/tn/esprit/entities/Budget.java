
package tn.esprit.entities;

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
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="libelle")
    String libelle;
    @Column(name="anneebudgetaire")
    String anneebudgetaire;
    @Column(name="coutLogiciel")
    String coutLogiciel;
    @Column(name="coutMateriel")
    String coutMateriel;
    @Column(name="coutEtudeServ")
    String coutEtudeServ;
    @Column(name="BudgetN")
    String BudgetN;
    @Column(name="BudgetN1")
    String BudgetN1;
    @Column(name="BudgetN2")
    String BudgetN2;
    @Column(name="BudgetN3")
    String BudgetN3;
    @Column(name="Type")
    String type;
    @Column(name="UserId")
    Long userId;
    @ManyToOne
    // @JsonIgnore
    private EntiteSI entiteSI;

}
