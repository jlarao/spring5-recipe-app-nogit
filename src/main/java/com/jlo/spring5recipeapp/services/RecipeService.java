package com.jlo.spring5recipeapp.services;

import com.jlo.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService  {
    Set<Recipe> getRecipes();
}
