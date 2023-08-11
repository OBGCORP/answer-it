package com.obg.answerit.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class PostEntity {
    @Id
    private Long id;
    private Long userId;
    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
