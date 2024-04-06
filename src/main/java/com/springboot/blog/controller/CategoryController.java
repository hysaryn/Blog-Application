package com.springboot.blog.controller;

import com.springboot.blog.payload.CategoryDto;
import com.springboot.blog.service.CategoryService;
import java.util.List;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
  private CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }


  @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
    CategoryDto savedCategory = categoryService.addCategory(categoryDto);
    return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") long categoryId) {
    CategoryDto categoryDto = categoryService.getCategory(categoryId);
    return ResponseEntity.ok(categoryDto);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDto>> getCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  @PutMapping("{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,
      @PathVariable("id") long categoryId) {
    return ResponseEntity.ok(categoryService.updateCategory(categoryDto, categoryId));
  }

  @DeleteMapping("{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<String> deleteCategory(@PathVariable("id") long categoryId) {
    categoryService.deleteCategory(categoryId);
    return ResponseEntity.ok("Category deleted successfully");
  }
}
