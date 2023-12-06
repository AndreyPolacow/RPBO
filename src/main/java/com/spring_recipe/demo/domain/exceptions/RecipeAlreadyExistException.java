package com.spring_recipe.demo.domain.exceptions;

import static java.lang.String.format;

public class RecipeAlreadyExistException extends Exception{
    public RecipeAlreadyExistException(String name) {
        super(format("Recipe with name %s already exists", name));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}