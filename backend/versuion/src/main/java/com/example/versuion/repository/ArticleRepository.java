package com.example.versuion.repository;

import com.example.versuion.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByCodeArticle(String codeArticle);

    List<Article> findAllByCategoryId(Long idCategory);
   /* //jpql
   // @Query("SELECT a FROM article WHERE codeArticle = :code")
    //List<Article> findByCustomQuery(String code);

    @Query(value = "SELECT * FROM article WHERE code = :code",nativeQuery = true)
    List<Article> findByCustomQuery(@Param("code") String c);

    List<Article> findByCodeArticleIgnoreCaseAndDesignationIgnoreCase(String codeArticle, String designation);*/
}
