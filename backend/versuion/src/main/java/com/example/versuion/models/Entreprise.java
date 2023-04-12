/*
* Builder : desgine Patterne
* c'est une classe qui permet de construire un objet en exposant des
* méthodes qui contient les memes noms que les attributs et renvoyant  */
package com.example.versuion.models;

import com.example.versuion.Dto.UtilisateurDto;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Entreprise extends AbstractEntity{

    private String nom;

    private String description;

    @Embedded
    private Adresse adresse;

    private String codefiscale;

    private String photo;

    private String email;

    private String numTel;

    private String siteWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateurs> utilisateurs;
}
