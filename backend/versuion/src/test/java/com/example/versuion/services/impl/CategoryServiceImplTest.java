package com.example.versuion.services.impl;

import com.example.versuion.Dto.CategoryDto;
import com.example.versuion.services.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void shouldSAveCategoryWithSuccess(){

        CategoryDto expectedCategoryDto = CategoryDto.builder()
                .codeCategory("Mon")
                .designation("Mon Desognation")
                .idEntreprise(1)
                .build();

        CategoryDto savedCategory = categoryService.save(expectedCategoryDto);


        assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(savedCategory.getCodeCategory(), expectedCategoryDto.getCodeCategory());
        assertEquals(savedCategory.getDesignation(), expectedCategoryDto.getDesignation());
        assertEquals(savedCategory.getIdEntreprise(), expectedCategoryDto.getIdEntreprise());



    }

}