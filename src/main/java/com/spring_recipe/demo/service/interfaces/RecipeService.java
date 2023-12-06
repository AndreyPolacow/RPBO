package com.spring_recipe.demo.service.interfaces;

import com.spring_recipe.demo.domain.dto.CreateRecipeRequest;
import com.spring_recipe.demo.domain.dto.RecipeDto;
import com.spring_recipe.demo.domain.entity.Recipe;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RecipeService {
    RecipeDto getRecipeByName(String name) throws RecipeNotFoundException;

    RecipeDto createRecipe(CreateRecipeRequest Recipe) throws RecipeAlreadyExistException;

    List<Recipe> getAllRecipes();

    RecipeDto updateRecipe(Recipe Recipe);

    void deleteRecipe(String RecipeId);
}