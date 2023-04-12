package com.example.versuion.Dto;

import com.example.versuion.models.Adresse;
import com.example.versuion.models.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdressDto {

    private String addresse1;

    private String addresse2;

    private String Ville;

    private String codePostale;

    private String pays;

    public static AdressDto fromEntity(Adresse adresse){
        if(adresse == null){
            return null;
        }
        return AdressDto.builder()
                .addresse1(adresse.getAddresse1())
                .addresse2(adresse.getAddresse2())
                .Ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdressDto adressDto){
        if(adressDto == null){
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAddresse1(adressDto.getAddresse1());
        adresse.setAddresse2(adressDto.getAddresse2());
        adresse.setVille(adressDto.getVille());
        adresse.setCodePostale(adressDto.codePostale);
        adresse.setPays(adressDto.getPays());

        return adresse;
    }
}
