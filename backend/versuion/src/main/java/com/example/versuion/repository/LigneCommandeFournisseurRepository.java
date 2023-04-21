package com.example.versuion.repository;

import com.example.versuion.models.LigneComandeClient;
import com.example.versuion.models.LigneComandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneComandeFournisseur, Long>
{
    List<LigneComandeFournisseur> findAllByCommandeFournisseurId(Long idCommande);

    List<LigneComandeFournisseur> findAllByArticleId(Long articleId);


}
