
package tn.esprit.entities;

        import com.fasterxml.jackson.annotation.JsonFormat;
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

@Table(name = "depense")
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateInsertion")
    Date dateInsertion;

    @Column(name="objetFacture")
    String objetFacture;

    @Column(name="numFacture")
    String numFacture;

    @Column(name="devise")
    String devise;

    @Column(name="montantFactureTND")
    String montantFactureTND;

    @Column(name="description")
    String description;

    @Column(name="statutFacture")
    String statutFacture;

    @Column(name="UserId")
    Long userId;

    @ManyToOne
    //@JsonIgnore
    ContatDeMarche contrat;

    @OneToOne
    // @JsonIgnore
    Facture facture;

}
