package com.example.versuion.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Fournisseur extends AbstractEntity{

    private String nom;

    private String prenom;

    @Embedded
    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "Fournisseur")
    private List<ComandeFournisseur> comandeFournisseurList;
}
