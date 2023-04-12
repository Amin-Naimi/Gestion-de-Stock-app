package com.example.versuion.Dto;

import com.example.versuion.models.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVentDto {

    private Long id;

    private VentesDto ventes;

    private ArticleDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    public static LigneVentDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
        }

        return LigneVentDto.builder()
                .id(ligneVente.getId())
                .ventes(VentesDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantie())
                .prixUnitaire(ligneVente.getPrixUnitare())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVentDto ligneVentDto) {
        if (ligneVentDto == null) {
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVentDto.getId());
        ligneVente.setVente(VentesDto.toEntity(ligneVentDto.getVentes()));
        ligneVente.setArticle(ArticleDto.toEntity(ligneVentDto.getArticle()));
        ligneVente.setQuantie(ligneVentDto.getQuantite());
        ligneVente.setPrixUnitare(ligneVentDto.getPrixUnitaire());
        ligneVente.setIdEntreprise(ligneVentDto.getIdEntreprise());
        return ligneVente;
    }
}
