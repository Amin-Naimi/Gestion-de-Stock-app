package com.example.versuion.Dto;

import com.example.versuion.models.Adresse;
import com.example.versuion.models.ComandeFournisseur;
import com.example.versuion.models.Fournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;
@Builder
@Data
public class FournisseurDto {

    private Long id;

    private String nom;

    private String prenom;

    private AdressDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;


    @JsonIgnore
    private List<ComandeFournisseurDto> comandeFournisseurList;

    //Mapping
    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(AdressDto.fromEntity(fournisseur.getAdresse()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(AdressDto.toEntity(fournisseurDto.getAdresse()));
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());

        return fournisseur;
    }
}
