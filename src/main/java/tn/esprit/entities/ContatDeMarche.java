package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contatDeMarche")
public class ContatDeMarche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="reference")
    String reference;
    @Column(name="objetContrat")
    String objetContrat;
    @Column(name="intituleProjet")
    String intituleProjet;
    @Column(name="montantHT")
    String montantHT;
    @Column(name="montantTTC")
    String montantTTC;
    @Column(name="devise")
    String devise;
    @Column(name="delaiGarantie")
    String delaiGarantie;
    @Column(name="observation")
    String observation;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateAcquisition")
    Date dateAcquisition;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateReceptionProvisoire")
    Date dateReceptionProvisoire;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateReceptionDefinitive")
    Date dateReceptionDefinitive;
    @Column(name="UserId")
    Long userId;


    @ManyToOne
    //@JsonIgnore
    Budget budget;

    @ManyToOne
    //@JsonIgnore
    Fournisseur fournisseur;
}
