package com.spring_recipe.demo.api.rest;

import com.spring_recipe.demo.domain.dto.CreateStepRequest;
import com.spring_recipe.demo.domain.entity.Step;
import com.spring_recipe.demo.domain.dto.StepDto;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;
import com.spring_recipe.demo.service.interfaces.StepService;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@AutoConfiguration
@RestController
@RequiredArgsConstructor
public class StepController {
    private final StepService stepService;

    @GetMapping("/Steps/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<StepDto> getStepById(@PathVariable String id) throws RecipeNotFoundException {
        return ResponseEntity.ok(stepService.getStepById(id));
    }

    @PostMapping("/Steps")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<StepDto> createStep(@RequestBody CreateStepRequest Step) throws RecipeAlreadyExistException {
        return ResponseEntity.ok(stepService.createStep(Step));
    }

    @PatchMapping("/Steps")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<StepDto> updateStep(@RequestBody Step Step) {
        return ResponseEntity.ok(stepService.updateStep(Step));
    }

    @DeleteMapping("/Steps/{id}")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity deleteStep(@PathVariable String id) {
        stepService.deleteStep(id);
        return ResponseEntity.ok()
                .body(format("Step with id= %s deleted", id));
    }
}