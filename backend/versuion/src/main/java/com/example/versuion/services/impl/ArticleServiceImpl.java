package com.example.versuion.services.impl;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.Dto.LigneCommandeClientDto;
import com.example.versuion.Dto.LigneCommandeFournisseurDto;
import com.example.versuion.Dto.LigneVentDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.exception.InvalidOperationException;
import com.example.versuion.models.*;
import com.example.versuion.repository.*;
import com.example.versuion.services.ArticleService;
import com.example.versuion.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    private LigneVenteRepository ligneVenteRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    //Injection par constructeur
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository,
                              LigneVenteRepository ligneVenteRepository,
                              LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository,
                              LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.articleRepository = articleRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }
    @Autowired CategoryRepository categoryRepository;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        Long idCategory = articleDto.getCategory().getId();
        Optional<Category> category = categoryRepository.findById(idCategory);
        Article article = ArticleDto.toEntity(articleDto);
        article.setCategory(category.get());
        articleRepository.save(article);
        return ArticleDto.fromEntity(article);
    }

    @Override
    public ArticleDto findById(Long articleId) {
        if (articleId == null) {
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec l' Id" + articleId + "dans la base", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (codeArticle == null) {
            log.error("Article code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);
        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec l' code " + codeArticle + "dans la base", ErrorCodes.ARTICLE_NOT_FOUND));
    }

    //mapping 5ater traja3 liste
    //expretion lamda  .map(ArticleDto::fromEntity)
    // regrouper l'objet dans une liste .collect(Collectors.toList());    }
    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long articleId) {
        if (articleId == null) {
            log.error("Article id is null");
            return;//por quitter la méthode
        }
        List<LigneComandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByArticleId(articleId);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneComandeFournisseur> ligneCommandeFournisseurs = ligneCommandeFournisseurRepository.findAllByArticleId(articleId);
        if (!ligneCommandeFournisseurs.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByArticleId(articleId);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        articleRepository.deleteById(articleId);
    }

    @Override
    public List<LigneVentDto> findHistoriqueVentes(Long idArticle) {
        return ligneVenteRepository.findAllByArticleId(idArticle).stream()
                .map(LigneVentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Long idArticle) {
        return ligneCommandeClientRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Long idArticle) {
        return ligneCommandeFournisseurRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Long idCategory) {
        return articleRepository.findAllByCategoryId(idCategory).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }
}
