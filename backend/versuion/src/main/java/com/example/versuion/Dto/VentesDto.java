package com.example.versuion.Dto;

import com.example.versuion.models.Ventes;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {

    private Long id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVentDto> ligneVentes;

    private Integer idEntreprise;

    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDto dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdEntreprise(dto.getIdEntreprise());
        return ventes;
    }
}


