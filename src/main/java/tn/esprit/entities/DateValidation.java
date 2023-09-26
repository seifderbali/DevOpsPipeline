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
@Table(name = "dateValidation")
public class DateValidation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="validationCC")
    Date validationCC;
    @Column(name="decisionComiteCC")
    String decisionComiteCC;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="validationTech")
    Date validationTech;
    @Column(name="decisionComiteTech")
    String decisionComiteTech;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="validationTechFinanciaire")
    Date validationTechFinanciaire;
    @Column(name="decisionComiteTechFin")
    String decisionComiteTechFin;
    @Column(name="UserId")
    Long userId;
/*
    @OneToOne(mappedBy = "dateValidation")
    //  @JsonIgnore
    ComiteTechnique comiteTechnique ;

 */
}
