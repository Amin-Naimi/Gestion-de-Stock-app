package com.example.versuion.repository;

import com.example.versuion.models.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Long> {

    List<LigneVente> findAllByArticleId(Long articleId);

    List<LigneVente> findAllByVenteId(Long id);
}
