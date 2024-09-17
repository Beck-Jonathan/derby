package com.beck.javaiii_kirkwood.budget_app.controllers;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryDAO;
import com.beck.javaiii_kirkwood.budget_app.data.CategoryRepository;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryRepositoryImpl;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/category_by_year/")
public class YearBraekdownController {
  private final CategoryRepositoryImpl categoryRepository;

  @Autowired
  public YearBraekdownController(CategoryRepositoryImpl categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @GetMapping
  public List<Category_VM> getAllCategory() {
    return categoryRepository.findAll();
  }

  @PostMapping
  public Category_VM addCategory(@RequestBody Category_VM category) {
    return categoryRepository.save(category);
  }

  @GetMapping(params = {"sort","user_id","type"} )

      public List<Category_VM> getCategoryforYear(@RequestParam String sort,@RequestParam int user_id, @RequestParam String type) throws SQLException {
       if (type.equals("pie")){
         return categoryRepository.getOneYearAnalysis(Integer.valueOf(sort),user_id);
       }
       if (type.equals("bar")){
         return categoryRepository.getOneCategoryAnalysis(sort,user_id);
       }
       return null;
      }

  @GetMapping("/{id}")
  public Category_VM getCategoryById(@PathVariable Integer id) {
    return categoryRepository.findById(id).orElse(null);
  }

  @PutMapping("/{id}")
  public Category_VM updateCategory(@PathVariable Integer id, @RequestBody Category_VM updatedCategory) {
    if (categoryRepository.existsById(id)) {
      updatedCategory.setCount(id);
      return categoryRepository.save(updatedCategory);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable Integer id) {
    categoryRepository.deleteById(id);
  }
}



