package com.spring_recipe.demo.repository;

import com.spring_recipe.demo.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    @Query(value = "SELECT p FROM Recipe p")
    List<Recipe> getAll();
    Optional<Recipe> findByName(String name);

    Boolean existsByName(String name);
}