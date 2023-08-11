package com.obg.answerit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class CommentEntity {
    @Id
    private Long id;
    private Long postId;
    private Long userId;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
