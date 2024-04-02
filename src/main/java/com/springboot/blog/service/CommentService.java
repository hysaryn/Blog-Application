package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;

public interface CommentService {
  CommentDto createComment(long postId, CommentDto commentDto);
  }
}
