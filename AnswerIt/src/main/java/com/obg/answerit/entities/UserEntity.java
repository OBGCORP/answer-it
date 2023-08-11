package com.obg.answerit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String password;
}
