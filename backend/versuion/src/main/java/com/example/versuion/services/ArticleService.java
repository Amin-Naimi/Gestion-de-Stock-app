package com.example.versuion.services;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.models.Article;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Long articleId);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    void delete (Long articleId);


}
