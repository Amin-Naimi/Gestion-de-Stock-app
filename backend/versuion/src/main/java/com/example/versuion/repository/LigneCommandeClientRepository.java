package com.example.versuion.repository;

import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.models.LigneComandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneComandeClient, Long> {

    List<LigneComandeClient> findAllByCommandeClientId(Long id);

    List<LigneComandeClient> findAllByArticleId(Long articleId);

}
