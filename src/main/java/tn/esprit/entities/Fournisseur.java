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
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    @Column(name="code")
    String code;
    @Column(name="name")
    String name;
    @Column(name="immatFiscal")
    String immatFiscal;
    @Column(name="contact")
    String contact;
    @Column(name="mail")
    String mail;
    @Column(name="siteWeb")
    String siteWeb;
    @Column(name="tel")
    String tel;
    @Column(name="UserId")
    Long userId;
/*
    @OneToMany(cascade = CascadeType.ALL,mappedBy="fournisseur")
    Set<ContatDeMarche> contatDeMarches;
*/

}
