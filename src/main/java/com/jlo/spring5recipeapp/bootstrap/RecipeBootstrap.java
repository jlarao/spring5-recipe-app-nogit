package com.jlo.spring5recipeapp.bootstrap;

import com.jlo.spring5recipeapp.domain.*;
import com.jlo.spring5recipeapp.repositories.CategoryRepository;
import com.jlo.spring5recipeapp.repositories.RecipeRepository;
import com.jlo.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("loading bootstrap data");
        recipeRepository.saveAll(getRecipes());
    }

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teeSpoonUomOptional = unitOfMeasureRepository.findByDescription("teaspoon");
        if(!teeSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent()){
            throw  new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cups");
        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        //get optional
        UnitOfMeasure eachUOM = eachUomOptional.get();
        UnitOfMeasure tableSpoonUOM = tableSpoonUomOptional.get();
        UnitOfMeasure teeSpoonUOM = teeSpoonUomOptional.get();
        UnitOfMeasure dashUOM = dashUomOptional.get();
        UnitOfMeasure pintUOM = pintUomOptional.get();
        UnitOfMeasure cupsUOM = cupsUomOptional.get();

        //get categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("american");
        if(!americanCategoryOptional.isPresent()){
            throw  new RuntimeException("Expected category not found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expcted category not found;");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Guacate Perfect");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);
        /*guacRecipe.getIngredients().add(new Ingredient("ripe avocado", new BigDecimal(2),guacRecipe,eachUOM));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(5),guacRecipe,teeSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1),guacRecipe,tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),guacRecipe,tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2),guacRecipe,eachUOM));
        guacRecipe.getIngredients().add(new Ingredient(" cilantro ", new BigDecimal(2),guacRecipe,tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1),guacRecipe,dashUOM));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(2),guacRecipe,eachUOM));*/

        guacRecipe.addIngredients(new Ingredient("ripe avocado", new BigDecimal(2),guacRecipe,eachUOM));
        guacRecipe.addIngredients(new Ingredient("Kosher salt", new BigDecimal(5),guacRecipe,teeSpoonUOM));
        guacRecipe.addIngredients(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1),guacRecipe,tableSpoonUOM));
        guacRecipe.addIngredients(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2),guacRecipe,tableSpoonUOM));
        guacRecipe.addIngredients(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2),guacRecipe,eachUOM));
        guacRecipe.addIngredients(new Ingredient(" cilantro ", new BigDecimal(2),guacRecipe,tableSpoonUOM));
        guacRecipe.addIngredients(new Ingredient("freshly grated black pepper", new BigDecimal(1),guacRecipe,dashUOM));
        guacRecipe.addIngredients(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(2),guacRecipe,eachUOM));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);

        //tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacosRecipe.setCookTime(0);;
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");
        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");
        tacosNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacosNotes);
        tacosRecipe.getIngredients().add(new Ingredient("ancho chili powder",new BigDecimal(2),tacosRecipe,tableSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("dried oregano",new BigDecimal(1),tacosRecipe,teeSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("dried cumin",new BigDecimal(1),tacosRecipe,teeSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("sugar",new BigDecimal(1),tacosRecipe,teeSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(.5),tacosRecipe,teeSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("clove garlic, finely chopped",new BigDecimal(1),tacosRecipe,eachUOM));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zest",new BigDecimal(1),tacosRecipe,tableSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice",new BigDecimal(3),tacosRecipe,tableSpoonUOM));
        tacosRecipe.getIngredients().add(new Ingredient(" olive oil",new BigDecimal(2),tacosRecipe,cupsUOM));
        tacosRecipe.getIngredients().add(new Ingredient("skinless, boneless chicken thighs",new BigDecimal(4),tacosRecipe,eachUOM));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);
        recipes.add(tacosRecipe);
        return  recipes;

    }
}
