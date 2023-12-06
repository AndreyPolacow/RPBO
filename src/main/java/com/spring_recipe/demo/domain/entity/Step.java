 package com.spring_recipe.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "step")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Step {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String description;

    @Column
    private UUID dependencyRecipeId;

    @Column
    private String image;
}
