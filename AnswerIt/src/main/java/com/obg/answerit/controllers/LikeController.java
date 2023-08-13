package com.obg.answerit.controllers;

import com.obg.answerit.entities.LikeEntity;
import com.obg.answerit.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping()
    public List<LikeEntity> getAllLikes(@RequestParam Optional<Long> postId,
                                        @RequestParam Optional<Long> userId) {
        return likeService.getLikesByParams(postId, userId);
    }
}
