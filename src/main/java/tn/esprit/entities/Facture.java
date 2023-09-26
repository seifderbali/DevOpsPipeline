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
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    @Column(name="numFacture")
    String numFacture;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateReceptionDCD")
    Date dateReceptionDCD;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateEnvoiDirectionSupportMaintenance")
    Date dateEnvoiDirectionSupportMaintenance;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateRetourDirectionSupportMaintenance")
    Date dateRetourDirectionSupportMaintenance;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateValidationChefDepartement")
    Date dateValidationChefDepartement;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateRetourValidationChefDepartement")
    Date dateRetourValidationChefDepartement;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateIncidentFournisseur")
    Date dateIncidentFournisseur;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateRegularizationFournisseur")
    Date dateRegularizationFournisseur;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateEnvoiAssurance")
    Date dateEnvoiAssurance;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateOrdonnancementDCD")
    Date dateOrdonnancementDCD;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="dateRetourDCD")
    Date dateRetourDCD;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="Date2OrdonnancementDCD")
    Date Date2OrdonnancementDCD;

    @Column(name="UserId")
    Long userId;

}
