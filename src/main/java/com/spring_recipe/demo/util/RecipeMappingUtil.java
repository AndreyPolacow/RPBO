package com.spring_recipe.demo.util;

import com.spring_recipe.demo.domain.dto.CreateRecipeRequest;
import com.spring_recipe.demo.domain.dto.RecipeDto;
import com.spring_recipe.demo.domain.entity.Recipe;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class RecipeMappingUtil {

    public static RecipeDto mapToRecipeDto(Recipe recipe) {
        return RecipeDto.builder()
                .name(recipe.getName())
                .description(recipe.getDescription())
                .image(recipe.getImage())
                .userId(recipe.getUserId())
                .listId(recipe.getListId())
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static Recipe mapToRecipeFromRequest(CreateRecipeRequest request) {
        return Recipe.builder()
                .name(request.getName())
                .description(request.getDescription())
                .image(request.getImage())
                .userId(request.getUserId())
                .listId(request.getListId())
                .build();
    }
}