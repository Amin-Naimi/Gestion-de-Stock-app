package com.example.versuion.controller;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.Dto.LigneVentDto;
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
    public List<LigneVentDto> findHistoriqueVentes(Long idArticle) {
        return articleService.findHistoriqueVentes(idArticle);
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Long idArticle) {
        return articleService.findHistoriqueCommandeClient(idArticle);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Long idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Long idCategory) {
        return articleService.findAllArticleByIdCategory(idCategory);
    }

    @Override
    public void delete(Long articleId) {
        articleService.delete(articleId);
    }

}
