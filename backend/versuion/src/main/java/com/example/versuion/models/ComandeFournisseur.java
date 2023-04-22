package com.example.versuion.models;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class ComandeFournisseur extends AbstractEntity{

    private String code;

    private Instant dateComande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur Fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    private List<LigneComandeFournisseur> ligneComandeFournisseurList;
}
