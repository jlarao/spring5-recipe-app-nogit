package com.jlo.spring5recipeapp.controllers;

import com.jlo.spring5recipeapp.domain.Category;
import com.jlo.spring5recipeapp.domain.UnitOfMeasure;
import com.jlo.spring5recipeapp.repositories.CategoryRepository;
import com.jlo.spring5recipeapp.repositories.UnitOfMeasureRepository;
import com.jlo.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {
   /* private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }
*/
   private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
       /* Optional<Category> optionalCategory = categoryRepository.findByDescription("american");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("teaspoon");

        System.out.println("Cat id: " +optionalCategory.get().getId());
        System.out.println("uom id: " +optionalUnitOfMeasure.get().getId());*/
       log.debug("getting index page");
       model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
