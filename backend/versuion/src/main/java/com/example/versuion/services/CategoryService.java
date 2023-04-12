package com.example.versuion.services;

import com.example.versuion.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto update(Long id, CategoryDto Dto);

    CategoryDto findById(Long id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Long id);}
