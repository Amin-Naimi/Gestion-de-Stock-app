package com.example.versuion.services;

import com.example.versuion.Dto.ComandeFournisseurDto;
import io.swagger.annotations.Api;

import java.util.List;

import static com.example.versuion.utiles.Constants.APP_ROOT;

public interface CommandeFournisseurService {

    ComandeFournisseurDto save(ComandeFournisseurDto dto);

   /* CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    CommandeFournisseurDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);
    CommandeFournisseurDto updateFournisseur(Integer idCommande, Integer idFournisseur);
    CommandeFournisseurDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle);
    // Delete article ==> delete LigneCommandeFournisseur
    CommandeFournisseurDto deleteArticle(Integer idCommande, Integer idLigneCommande);
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande);
*/
   ComandeFournisseurDto findById(Long id);

    ComandeFournisseurDto findByCode(String code);

    List<ComandeFournisseurDto> findAll();


    void delete(Long id);
}
