package com.spring_recipe.demo.domain.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStepRequest {
    private String description;
    private UUID dependencyRecipeId;
    private String image;
}