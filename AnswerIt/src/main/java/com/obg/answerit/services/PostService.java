package com.obg.answerit.services;

import com.obg.answerit.entities.PostEntity;
import com.obg.answerit.entities.UserEntity;
import com.obg.answerit.repositories.PostRepository;
import com.obg.answerit.requests.PostCreateRequest;
import com.obg.answerit.requests.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;
    public List<PostEntity> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    public PostEntity getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public PostEntity createPost(PostCreateRequest newPostRequest) {
        UserEntity user = userService.getUserById(newPostRequest.getUserId());
        if (user == null)
            return null;
        PostEntity postToSave = new PostEntity();
        postToSave.setId(newPostRequest.getId());
        postToSave.setText(newPostRequest.getText());
        postToSave.setTitle(newPostRequest.getTitle());
        postToSave.setUser(user);
        return postRepository.save(postToSave);
    }

    public PostEntity updatePost(Long postId, PostUpdateRequest updatePost) {
        Optional<PostEntity> post = postRepository.findById(postId);
        if (post.isPresent()) {
            PostEntity postToUpdate = post.get();
            postToUpdate.setText(updatePost.getText());
            postToUpdate.setTitle(updatePost.getTitle());
            postRepository.save(postToUpdate);
            return postToUpdate;
        }
        return null;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
