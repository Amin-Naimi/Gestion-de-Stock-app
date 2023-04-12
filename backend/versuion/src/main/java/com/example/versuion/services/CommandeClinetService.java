package com.example.versuion.services;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.Dto.LigneCommandeClientDto;

import java.util.List;

public interface CommandeClinetService {

    ComandeClientDto save(ComandeClientDto dto);

    //CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    //CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);
    //CommandeClientDto updateClient(Integer idCommande, Integer idClient);
   // CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);
    // Delete article ==> delete LigneCommandeClient
    //CommandeClientDto deleteArticle(Integer idCommande, Integer idLigneCommande);

    ComandeClientDto findById(Long id);

    ComandeClientDto findByCode(String code);

    List<ComandeClientDto> findAll();

    void delete(Long id);
}
