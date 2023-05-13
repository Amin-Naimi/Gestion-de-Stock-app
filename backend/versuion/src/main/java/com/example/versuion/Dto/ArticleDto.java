package com.example.versuion.Dto;

import com.example.versuion.models.Adresse;
import com.example.versuion.models.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private Long id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaire;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTTc;

    private String photo;

    private CategoryDto category;

    private Integer idEntreprise;

    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaire(article.getPrixUnitaire())
                .tauxTva(article.getTauxTva())
                .prixUnitaireTTc(article.getPrixUnitaireTTc())
                .photo(article.getPhoto())
                .idEntreprise(article.getIdEntreprise())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaire(articleDto.getPrixUnitaire());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTTc(articleDto.getPrixUnitaireTTc());
        article.setPhoto(articleDto.getPhoto());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));


        return article;
    }
}
