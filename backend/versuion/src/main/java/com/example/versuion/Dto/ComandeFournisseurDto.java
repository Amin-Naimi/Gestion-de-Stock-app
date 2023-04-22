package com.example.versuion.Dto;

import com.example.versuion.models.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class ComandeFournisseurDto {
    private Long id;

    private String code;

    private Instant dateComande;

    private EtatCommande etatCommande;

    private FournisseurDto fournisseur;

    private Integer idEntreprise;

    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneComandeFournisseurList;

    //Mapping trasformer l entité en dto
    public static ComandeFournisseurDto fromEntity(ComandeFournisseur comandeFournisseur){
        if(comandeFournisseur == null){
            return null;
        }
        return ComandeFournisseurDto.builder()
                .id(comandeFournisseur.getId())
                .code(comandeFournisseur.getCode())
                .dateComande(comandeFournisseur.getDateComande())
                .fournisseur(FournisseurDto.fromEntity(comandeFournisseur.getFournisseur()))
                .idEntreprise(comandeFournisseur.getIdEntreprise())
                .etatCommande(comandeFournisseur.getEtatCommande())
                .build();
    }

    public static ComandeFournisseur toEntity(ComandeFournisseurDto comandeFournisseurDto){
        if(comandeFournisseurDto == null){
            return null;
        }
        ComandeFournisseur comandeFournisseur = new ComandeFournisseur();
       comandeFournisseur.setId(comandeFournisseurDto.getId());
       comandeFournisseur.setCode(comandeFournisseurDto.getCode());
       comandeFournisseur.setDateComande(comandeFournisseurDto.getDateComande());
       comandeFournisseur.setFournisseur(FournisseurDto.toEntity(comandeFournisseurDto.getFournisseur()));
       comandeFournisseur.setEtatCommande(comandeFournisseurDto.getEtatCommande());
       comandeFournisseur.setIdEntreprise(comandeFournisseurDto.getIdEntreprise());

        return comandeFournisseur;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
