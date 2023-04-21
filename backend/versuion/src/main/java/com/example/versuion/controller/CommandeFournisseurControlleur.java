package com.example.versuion.controller;

import com.example.versuion.Dto.ComandeFournisseurDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.controller.api.CommandeFournisseurApi;
import com.example.versuion.models.EtatCommande;
import com.example.versuion.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CommandeFournisseurControlleur implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurControlleur(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public ComandeFournisseurDto save(ComandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    public ComandeFournisseurDto findById(Long id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public ComandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public List<ComandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();

    }

    @Override
    public void delete(Long id) {
        commandeFournisseurService.delete(id);
    }

    @Override
    public ComandeFournisseurDto updateEtatCommande(Long idCommande, EtatCommande etatCommande) {
        return commandeFournisseurService.updateEtatCommande(idCommande, etatCommande);
    }

    @Override
    public ComandeFournisseurDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite) {
        return commandeFournisseurService.updateQuantiteCommande(idCommande, idLigneCommande, quantite);
    }

    @Override
    public ComandeFournisseurDto updateFournisseur(Long idCommande, Long idFournisseur) {
        return commandeFournisseurService.updateFournisseur(idCommande, idFournisseur);
    }

    @Override
    public ComandeFournisseurDto updateArticle(Long idCommande, Long idLigneCommande, Long idArticle) {
        return commandeFournisseurService.updateArticle(idCommande, idLigneCommande, idArticle);
    }

    @Override
    public ComandeFournisseurDto deleteArticle(Long idCommande, Long idLigneCommande) {
        return commandeFournisseurService.deleteArticle(idCommande, idLigneCommande);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Long idCommande) {
        return commandeFournisseurService.findAllLignesCommandesFournisseurByCommandeFournisseurId(idCommande);
    }


}
