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
public class SteplistDto {
    private UUID nextId;
    private UUID stepId;
    private LocalDateTime requestTime;
}