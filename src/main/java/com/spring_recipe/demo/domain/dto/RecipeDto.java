package com.spring_recipe.demo.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RecipeDto {
    private String name;
    private int userId;
    private String description;
    private String image;
    private UUID listId;
    private LocalDateTime requestTime;
}