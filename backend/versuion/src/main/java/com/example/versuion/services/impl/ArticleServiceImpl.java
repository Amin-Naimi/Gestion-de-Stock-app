package com.example.versuion.services.impl;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.models.Article;
import com.example.versuion.repository.ArticleRepository;
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

    //Injection par constructeur
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}",articleDto);
            throw new InvalidEntityException("l'article n'est pas valide",ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Long articleId) {
        if(articleId == null){
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(articleId);
        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow( () ->
                new EntityNotFoundException("Aucun article avec l' Id"+ articleId+"dans la base",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(codeArticle == null){
            log.error("Article code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(codeArticle);
        ArticleDto articleDto = ArticleDto.fromEntity(article.get());
        return Optional.of(articleDto).orElseThrow( () ->
                new EntityNotFoundException("Aucun article avec l' code "+ codeArticle+"dans la base",ErrorCodes.ARTICLE_NOT_FOUND));
    }

    //mapping 5ater traja3 liste
    //expretion lamda  .map(ArticleDto::fromEntity)
    // regrouper l'objet dans une liste .collect(Collectors.toList());    }
    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());    }

    @Override
    public void delete(Long articleId) {
        if(articleId == null){
            log.error("Article id is null");
            return;//por quitter la méthode
        }
        articleRepository.deleteById(articleId);
    }
}
