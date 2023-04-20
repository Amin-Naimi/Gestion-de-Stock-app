package com.example.versuion.Dto;

import com.example.versuion.models.Article;
import com.example.versuion.models.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;
@Builder
@Data
public class CategoryDto {

    private Long id;

    private String codeCategory;

    private String designation;

    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articleList;
//Mapping
    public static CategoryDto fromEntity(Category category){
        if(category == null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }
        Category category = new Category();
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());

        return category;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", codeCategory='" + codeCategory + '\'' +
                ", designation='" + designation + '\'' +
                ", idEntreprise=" + idEntreprise +
                ", articleList=" + articleList +
                '}';
    }
}
