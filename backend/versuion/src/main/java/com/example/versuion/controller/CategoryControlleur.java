package com.example.versuion.controller;

import com.example.versuion.Dto.CategoryDto;
import com.example.versuion.controller.api.CategoryApi;
import com.example.versuion.services.CategoryService;
import com.example.versuion.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControlleur implements CategoryApi {

    CategoryService categoryService;

    @Autowired
    public CategoryControlleur(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto Dto) {
        return categoryService.update(id, Dto);
    }

    @Override
    public CategoryDto findById(Long idCategory) {
        return categoryService.findById(idCategory);
    }

    @Override
    public CategoryDto findByCode(String codeCategory) {
        return categoryService.findByCode(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryService.delete(id);

    }
}
