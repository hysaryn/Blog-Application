package com.springboot.blog.service;

import com.springboot.blog.payload.CategoryDto;
import org.springframework.stereotype.Service;

public interface CategoryService {
  CategoryDto addCategory(CategoryDto categoryDto);

}
