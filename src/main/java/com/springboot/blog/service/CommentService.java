package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import java.util.List;

public interface CommentService {
  CommentDto createComment(long postId, CommentDto commentDto);

  List<CommentDto> getCommentByPostId(long postId);
}
