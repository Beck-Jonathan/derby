package com.beck.javaiii_kirkwood.budget_app.controllers;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryRepository;

import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category_by_year")
public class YearBraekdownController {
  private final CategoryRepository categoryRepository;

  @Autowired
  public YearBraekdownController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @GetMapping
  public List<Category_VM> getAllTeams() {
    return categoryRepository.findAll();
  }

  @PostMapping
  public Category_VM addBook(@RequestBody Category_VM team) {
    return categoryRepository.save(team);
  }

  @GetMapping("/{id}")
  public Category_VM getBookById(@PathVariable Integer id) {
    return categoryRepository.findById(id).orElse(null);
  }

  @PutMapping("/{id}")
  public Category_VM updateTeam(@PathVariable Integer id, @RequestBody Category_VM updatedTeam) {
    if (categoryRepository.existsById(id)) {
      updatedTeam.setCount(id);
      return categoryRepository.save(updatedTeam);
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Integer id) {
    categoryRepository.deleteById(id);
  }
}



