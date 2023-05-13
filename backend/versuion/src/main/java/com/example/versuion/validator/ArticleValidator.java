package com.example.versuion.validator;

import com.example.versuion.Dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if (articleDto == null) {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la designation de l'article");
            errors.add("Veuillez renseigner le prix unitaire HT l'article");
            errors.add("Veuillez renseigner le taux TVA de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }

        if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
            errors.add("Veuillez renseigner le code de l'article");
        }
        if (!StringUtils.hasLength(articleDto.getDesignation())) {
            errors.add("Veuillez renseigner la designation de l'article");
        }
        if (articleDto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire HT l'article");
        }
        if (articleDto.getTauxTva() == null) {
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if (articleDto.getPrixUnitaireTTc() == null) {
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if (articleDto.getCategory() == null || articleDto.getCategory().getId() == null) {
            errors.add("Veuillez selectionner une categorie");
        }
        return errors;
    }
}
