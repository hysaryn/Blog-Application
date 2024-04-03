package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CommentController {
  private CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping("/posts/{postId}/comments")
  public ResponseEntity<CommentDto> createComment(@PathVariable(value="postId") long postId,
      @RequestBody CommentDto commentDto) {
    return new ResponseEntity<> (commentService.createComment(postId, commentDto), HttpStatus.CREATED);
  }

  @GetMapping("/posts/{postId}/comments")
  public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
    return commentService.getCommentsByPostId(postId);
  }

  @GetMapping("/posts/{postId}/comments/{id}")
  public ResponseEntity<CommentDto> getCommentById(@PathVariable("postId") long postId,
      @PathVariable("id") long commentId) {
    CommentDto commentDto = commentService.getCommentById(postId, commentId);
    return new ResponseEntity<>(commentDto, HttpStatus.OK);
  }

  @PutMapping("/posts/{postId}/comments/{id}")
  public ResponseEntity<CommentDto> updateComment(@PathVariable("postId") long postId,
      @PathVariable("id") long commentId, @RequestBody CommentDto commentDto) {
    CommentDto updatedCommentDto = commentService.updateComment(postId, commentId, commentDto);
    return new ResponseEntity<>(updatedCommentDto, HttpStatus.OK);
  }

  @DeleteMapping("/posts/{postId}/comments/{id}")
  public ResponseEntity<String> deleteComment(@PathVariable("postId") long postId,
      @PathVariable("id") long commentId) {
    commentService.deleteComment(postId, commentId);
    return new ResponseEntity<>("Comment entity deleted successfully.", HttpStatus.OK);
  }
}
