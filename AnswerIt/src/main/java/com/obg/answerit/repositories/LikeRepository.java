package com.obg.answerit.repositories;

import com.obg.answerit.entities.LikeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    List<LikeEntity> findAllByUserIdAndPostId(Long userId, Long postId);

    List<LikeEntity> findAllByPostId(Long postId);

    List<LikeEntity> findAllByUserId(Long userId);
}
