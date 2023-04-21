package com.example.versuion.repository;

import com.example.versuion.models.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStkRepository extends JpaRepository<MvtStk,Long> {
    @Query("select sum(m.quantite) from MvtStk m where m.article.id = :idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Long idArticle);

    List<MvtStk> findAllByArticleId(Long idArticle);
}
