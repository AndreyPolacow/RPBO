package com.spring_recipe.demo.domain.exceptions;

import static java.lang.String.format;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException(String name) {
        super(format("Recipe with name %s not found", name));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}