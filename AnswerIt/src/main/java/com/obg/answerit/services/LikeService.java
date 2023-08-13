package com.obg.answerit.services;

import com.obg.answerit.entities.LikeEntity;
import com.obg.answerit.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    public List<LikeEntity> getLikesByParams(Optional<Long> postId, Optional<Long> userId) {
        if (postId.isPresent() && userId.isPresent()) {
            return likeRepository.findAllByUserIdAndPostId(postId.get(), userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findAllByPostId(postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findAllByUserId(userId.get());
        } else {
            return likeRepository.findAll();
        }
    }

}
