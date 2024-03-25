package com.exampleWebSecurityDB.WebSecurityDB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "authorities")
@Table
@Setter
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private  int userId;
    @Column
    private  String username;
    @Column
    private String authority;
}
