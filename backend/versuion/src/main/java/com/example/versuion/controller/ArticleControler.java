package com.example.versuion.controller;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.controller.api.ArticleApi;
import com.example.versuion.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleControler implements ArticleApi {
    ArticleService articleService;

    @Autowired
    public ArticleControler(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return articleService.save(articleDto);
    }

    @Override
    public ArticleDto findById(Long articleId) {
        return articleService.findById(articleId);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Long articleId) {
        articleService.delete(articleId);
    }
}
