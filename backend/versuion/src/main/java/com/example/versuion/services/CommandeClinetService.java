package com.example.versuion.services;

import com.example.versuion.Dto.ComandeClientDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.models.EtatCommande;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClinetService {

    ComandeClientDto save(ComandeClientDto dto);

    ComandeClientDto findById(Long id);

    ComandeClientDto findByCode(String code);

    List<ComandeClientDto> findAll();

    void delete(Long id);

    ComandeClientDto updateEtatCommande(Long idCommande, EtatCommande etatCommande);

    ComandeClientDto updateQuantiteCommande(Long idCommande, Long idLigneCommande, BigDecimal quantite);

    ComandeClientDto updateClient(Long idCommande, Long idClient);

    ComandeClientDto updateArticle(Long idCommande, Long idLigneCommande,Long newIdArticle);

    // Delete article ==> effacer tout une LigneCommandeClient
    ComandeClientDto deleteArticle(Long idCommande, Long idLigneCommande);

    List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Long idCommande);


}
