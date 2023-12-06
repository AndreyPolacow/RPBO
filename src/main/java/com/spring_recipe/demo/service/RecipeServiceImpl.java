package com.spring_recipe.demo.service;

import com.spring_recipe.demo.domain.dto.CreateRecipeRequest;
import com.spring_recipe.demo.domain.dto.RecipeDto;
import com.spring_recipe.demo.domain.entity.Recipe;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;
import com.spring_recipe.demo.repository.RecipeRepository;
import com.spring_recipe.demo.service.interfaces.RecipeService;
import com.spring_recipe.demo.util.RecipeMappingUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.spring_recipe.demo.util.RecipeMappingUtil.mapToRecipeDto;
import static com.spring_recipe.demo.util.RecipeMappingUtil.mapToRecipeFromRequest;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public RecipeDto getRecipeByName(String name) throws RecipeNotFoundException {
        return recipeRepository.findByName(name).stream()
                .map(RecipeMappingUtil::mapToRecipeDto)
                .findFirst()
                .orElseThrow(() -> new RecipeNotFoundException(name));
    }

    @Override
    @Transactional
    public RecipeDto createRecipe(CreateRecipeRequest request) throws RecipeAlreadyExistException {
        if (!recipeRepository.existsByName(request.getName())) {
            return mapToRecipeDto(recipeRepository.save(mapToRecipeFromRequest(request)));
        }
        throw new RecipeAlreadyExistException(request.getName());
    }



    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAll();
    }

    @Override
    @Transactional
    public RecipeDto updateRecipe(Recipe recipe) {
        return mapToRecipeDto(recipeRepository.save(recipe));
    }

    @Override   
    public void deleteRecipe(String recipeId) {
        recipeRepository.deleteById(UUID.fromString(recipeId));
    }
}