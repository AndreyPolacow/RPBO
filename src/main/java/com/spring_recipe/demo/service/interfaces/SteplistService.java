package com.spring_recipe.demo.service.interfaces;

import com.spring_recipe.demo.domain.dto.CreateSteplistRequest;
import com.spring_recipe.demo.domain.dto.SteplistDto;
import com.spring_recipe.demo.domain.entity.Steplist;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;

import org.springframework.stereotype.Service;

@Service
public interface SteplistService {
    SteplistDto getSteplistById(String SteplistId) throws RecipeNotFoundException;

    SteplistDto createSteplist(CreateSteplistRequest Steplist) throws RecipeAlreadyExistException;

    SteplistDto updateSteplist(Steplist steplist);

    void deleteSteplist(String SteplistId);
}