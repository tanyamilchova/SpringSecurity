package com.exampleWebSecurityDB.WebSecurityDB.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Table
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private  String username;
    @Column
    private String password;
    @Column
    private boolean enabled;
}
