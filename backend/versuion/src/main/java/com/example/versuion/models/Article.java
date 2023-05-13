package com.example.versuion.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Article extends AbstractEntity{

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaire;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTTc;

    private String photo;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneComandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneComandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;
}
