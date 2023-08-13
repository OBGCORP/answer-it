package com.obg.answerit.services;

import com.obg.answerit.entities.CommentEntity;
import com.obg.answerit.entities.PostEntity;
import com.obg.answerit.entities.UserEntity;
import com.obg.answerit.repositories.CommentRepository;
import com.obg.answerit.requests.CommentCreateRequest;
import com.obg.answerit.requests.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    public List<CommentEntity> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    public CommentEntity getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public CommentEntity createComment(CommentCreateRequest commentCreateRequest) {
        UserEntity user = userService.getUserById(commentCreateRequest.getUserId());
        PostEntity post = postService.getPostById(commentCreateRequest.getPostId());
        if (user != null && post != null) {
            CommentEntity comment = new CommentEntity();
            comment.setId(commentCreateRequest.getId());
            comment.setUser(user);
            comment.setPost(post);
            comment.setText(commentCreateRequest.getText());
            return commentRepository.save(comment);
        }
        return null;
    }

    public CommentEntity updateComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<CommentEntity> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            CommentEntity commentToUpdate = comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentToUpdate);
        }
        return null;
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
