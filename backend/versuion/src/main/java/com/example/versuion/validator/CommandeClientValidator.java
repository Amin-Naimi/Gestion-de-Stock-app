package com.example.versuion.validator;

import com.example.versuion.Dto.ComandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(ComandeClientDto comandeClientDto) {
        List<String> errors = new ArrayList<>();
        if (comandeClientDto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez renseigner l'etat de la commande");
            errors.add("Veuillez renseigner le client");
            return errors;
        }

        if (!StringUtils.hasLength(comandeClientDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande");
        }
        if (comandeClientDto.getDateComande() == null) {
            errors.add("Veuillez renseigner la date de la commande");
        }
        if (!StringUtils.hasLength(comandeClientDto.getEtatCommande().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }
        if (comandeClientDto.getClient() == null || comandeClientDto.getClient().getId() == null) {
            errors.add("Veuillez renseigner le client");
        }

        return errors;
    }
}
