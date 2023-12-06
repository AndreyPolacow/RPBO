 package com.spring_recipe.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "steplist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Steplist {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private UUID nextId;

    @Column
    private UUID stepId;

}
