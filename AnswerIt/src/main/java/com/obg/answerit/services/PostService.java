package com.obg.answerit.services;

import com.obg.answerit.entities.PostEntity;
import com.obg.answerit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    public List<PostEntity> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    public PostEntity getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public PostEntity createPost(PostEntity newPost) {
        return postRepository.save(newPost);
    }
}
