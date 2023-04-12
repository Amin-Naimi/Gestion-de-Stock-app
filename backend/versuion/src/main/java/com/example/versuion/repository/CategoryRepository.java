package com.example.versuion.repository;

import com.example.versuion.models.Article;
import com.example.versuion.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCodeCategory(String codeCategory);

}
