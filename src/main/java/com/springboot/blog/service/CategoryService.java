package com.springboot.blog.service;

import com.springboot.blog.payload.CategoryDto;
import java.util.List;
import org.springframework.stereotype.Service;

public interface CategoryService {
  CategoryDto addCategory(CategoryDto categoryDto);

  CategoryDto getCategory(long categoryId);

  List<CategoryDto> getAllCategories();

  CategoryDto updateCategory(CategoryDto categoryDto, long categoryId);

  void deleteCategory(long categoryId);

}
