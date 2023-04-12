package com.example.versuion.validator;

import com.example.versuion.Dto.ComandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(ComandeFournisseurDto comandeFournisseurDto) {
        List<String> errors = new ArrayList<>();
        if (comandeFournisseurDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(comandeFournisseurDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (comandeFournisseurDto.getDateComande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(comandeFournisseurDto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (comandeFournisseurDto.getFournisseur() == null || comandeFournisseurDto.getFournisseur().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }

        return errors;
    }
}
