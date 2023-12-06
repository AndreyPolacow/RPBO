package com.spring_recipe.demo.util;

import com.spring_recipe.demo.domain.dto.CreateSteplistRequest;
import com.spring_recipe.demo.domain.dto.SteplistDto;
import com.spring_recipe.demo.domain.entity.Steplist;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class SteplistMappingUtil {

    public static SteplistDto mapToSteplistDto(Steplist steplist) {
        return SteplistDto.builder()
                .nextId(steplist.getNextId())
                .stepId(steplist.getStepId())
                .requestTime(LocalDateTime.now())
                .build();
    }

    public static Steplist mapToSteplistFromRequest(CreateSteplistRequest request) {
        return Steplist.builder()
                .nextId(request.getNextId())
                .stepId(request.getStepId())
                .build();
    }
}