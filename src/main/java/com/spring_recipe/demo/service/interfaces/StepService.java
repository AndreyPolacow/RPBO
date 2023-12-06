package com.spring_recipe.demo.service.interfaces;

import com.spring_recipe.demo.domain.dto.CreateStepRequest;
import com.spring_recipe.demo.domain.dto.StepDto;
import com.spring_recipe.demo.domain.entity.Step;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;

import org.springframework.stereotype.Service;

@Service
public interface StepService {
    StepDto getStepById(String StepId) throws RecipeNotFoundException;

    StepDto createStep(CreateStepRequest Step) throws RecipeAlreadyExistException;

    StepDto updateStep(Step Step);

    void deleteStep(String StepId);
}