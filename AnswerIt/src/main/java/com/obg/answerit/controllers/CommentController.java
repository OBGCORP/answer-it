package com.obg.answerit.controllers;

import com.obg.answerit.entities.CommentEntity;
import com.obg.answerit.requests.CommentCreateRequest;
import com.obg.answerit.requests.CommentUpdateRequest;
import com.obg.answerit.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping()
    public List<CommentEntity> getAllComments(@RequestParam Optional<Long> postId,
                                              @RequestParam Optional<Long> userId) {
        return commentService.getAllCommentsWithParam(userId, postId);
    }

    @GetMapping("/{commentId}")
    public CommentEntity getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public CommentEntity createComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return commentService.createComment(commentCreateRequest);
    }

    @PutMapping("/{commentId}")
    public CommentEntity updateComment(@PathVariable Long commentId,
                                       @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateComment(commentId, commentUpdateRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteCommentById(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }
}
