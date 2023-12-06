package com.spring_recipe.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationUser {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name ="role")
    private ApplicationUserRole role;
}
