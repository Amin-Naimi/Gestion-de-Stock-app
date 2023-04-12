package com.example.versuion.services.impl;

import com.example.versuion.Dto.ArticleDto;
import com.example.versuion.Dto.CategoryDto;
import com.example.versuion.exception.EntityNotFoundException;
import com.example.versuion.exception.ErrorCodes;
import com.example.versuion.exception.InvalidEntityException;
import com.example.versuion.exception.InvalidOperationException;
import com.example.versuion.models.Article;
import com.example.versuion.models.Category;
import com.example.versuion.repository.ArticleRepository;
import com.example.versuion.repository.CategoryRepository;
import com.example.versuion.services.CategoryService;
import com.example.versuion.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository ) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", categoryDto);
            throw new InvalidEntityException("La category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto))
        );
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            log.info("Category found with id {}",id);
            CategoryDto categoryDtoUpdate = CategoryDto.fromEntity(categoryOptional.get());
            categoryDtoUpdate.setCodeCategory(categoryDto.getCodeCategory());
            categoryDtoUpdate.setDesignation(categoryDto.getDesignation());
            categoryDtoUpdate.setIdEntreprise(categoryDto.getIdEntreprise());
            categoryRepository.save(CategoryDto.toEntity(categoryDtoUpdate));
            log.info("Category  with id {} updated",id);
            return categoryDtoUpdate;
        }
        else {
            log.info("Category with id {} not found",id);
            return null;
        }
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null) {
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow( () ->
                new EntityNotFoundException("Aucun category avec l' Id"+ id+"dans la base",ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Category CODE is null");
            return null;
        }
            Optional<Category> category = categoryRepository.findByCodeCategory(code);
            CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
            return Optional.of(categoryDto).orElseThrow( () ->
                    new EntityNotFoundException("Aucun category avec l' code "+ categoryDto+"dans la base",ErrorCodes.CATEGORY_NOT_FOUND));
        }

    @Override
    public List<CategoryDto> findAll() {
        //stream() pour boucler
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Category ID is null");
            return;
        }
        List<Article> articles = articleRepository.findAllByCategoryId(id);
        if (!articles.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        categoryRepository.deleteById(id);
    }

    }

