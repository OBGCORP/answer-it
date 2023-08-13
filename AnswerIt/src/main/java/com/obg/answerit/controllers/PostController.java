package com.obg.answerit.controllers;

import com.obg.answerit.entities.PostEntity;
import com.obg.answerit.requests.PostCreateRequest;
import com.obg.answerit.requests.PostUpdateRequest;
import com.obg.answerit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public PostEntity getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostEntity createPost(@RequestBody PostCreateRequest newPostRequest) {
        return postService.createPost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public PostEntity updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updatePost(postId, updatePost);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId) {
        postService.deletePostById(postId);
    }
}
