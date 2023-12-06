package com.spring_recipe.demo.api.rest;

import com.spring_recipe.demo.domain.dto.CreateSteplistRequest;
import com.spring_recipe.demo.domain.entity.Steplist;
import com.spring_recipe.demo.domain.dto.SteplistDto;
import com.spring_recipe.demo.domain.exceptions.RecipeAlreadyExistException;
import com.spring_recipe.demo.domain.exceptions.RecipeNotFoundException;
import com.spring_recipe.demo.service.interfaces.SteplistService;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import static java.lang.String.format;

@AutoConfiguration
@RestController
@RequiredArgsConstructor
public class SteplistController {

    private final SteplistService steplistService;

    @GetMapping("/Steplists/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<SteplistDto> getSteplistById(@PathVariable String id) throws RecipeNotFoundException {
        return ResponseEntity.ok(steplistService.getSteplistById(id));
    }

    @PostMapping("/Steplists")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<SteplistDto> createStep(@RequestBody CreateSteplistRequest Steplist) throws RecipeAlreadyExistException {
        return ResponseEntity.ok(steplistService.createSteplist(Steplist));
    }

    @PatchMapping("/Steplists")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity<SteplistDto> updateSteplist(@RequestBody Steplist Steplist) {
        return ResponseEntity.ok(steplistService.updateSteplist(Steplist));
    }

    @DeleteMapping("/Steplists/{id}")
    @PreAuthorize("hasAuthority('modification')")
    public ResponseEntity deleteStep(@PathVariable String id) {
        steplistService.deleteSteplist(id);
        return ResponseEntity.ok()
                .body(format("Step with id= %s deleted", id));
    }
}