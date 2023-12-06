package com.spring_recipe.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@AllArgsConstructor
public enum ApplicationUserRole {
    READER(Set.of(Permission.READ)),
    WRITER(Set.of(Permission.READ, Permission.MODIFY)),
    ADMIN(Set.of(Permission.READ, Permission.MODIFY, Permission.ADMIN));

    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> grantedAuthority() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(toSet());
    }
}