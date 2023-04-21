package com.example.versuion.controller.api;

import com.example.versuion.Dto.ComandeFournisseurDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.models.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.example.versuion.utiles.Constants.*;
@Api(COMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {

    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_ENDPOINT)
    ComandeFournisseurDto save(@RequestBody ComandeFournisseurDto dto);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT)
    ComandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Long id);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT)
    ComandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT)
    List<ComandeFournisseurDto> findAll();


    @DeleteMapping(DELETE_COMMANDE_FOURNISSEUR_ENDPOINT)
    void delete(@PathVariable("idCommandeFournisseur") Long id);

    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/etat/{idCommande}/{etatCommande}")
    ComandeFournisseurDto updateEtatCommande(@PathVariable("idCommande") Long idCommande, @PathVariable("etatCommande") EtatCommande etatCommande);
    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    ComandeFournisseurDto updateQuantiteCommande(@PathVariable("idCommande") Long idCommande,
                                                  @PathVariable("idLigneCommande") Long idLigneCommande, @PathVariable("quantite") BigDecimal quantite);
    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/fournisseur/{idCommande}/{idFournisseur}")
    ComandeFournisseurDto updateFournisseur(@PathVariable("idCommande") Long idCommande, @PathVariable("idFournisseur") Long idFournisseur);
    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    ComandeFournisseurDto updateArticle(@PathVariable("idCommande") Long idCommande,
                                         @PathVariable("idLigneCommande") Long idLigneCommande, @PathVariable("idArticle") Long idArticle);
    @DeleteMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/article/{idCommande}/{idLigneCommande}")
    ComandeFournisseurDto deleteArticle(@PathVariable("idCommande") Long idCommande, @PathVariable("idLigneCommande") Long idLigneCommande);

    @GetMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/lignesCommande/{idCommande}")
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(@PathVariable("idCommande") Long idCommande);


}
