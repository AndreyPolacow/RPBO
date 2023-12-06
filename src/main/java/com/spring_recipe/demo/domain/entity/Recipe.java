 package com.spring_recipe.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "recipe")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column
    private int userId;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private UUID listId;
}
