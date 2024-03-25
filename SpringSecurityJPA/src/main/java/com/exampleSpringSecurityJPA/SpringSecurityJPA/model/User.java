package com.exampleSpringSecurityJPA.SpringSecurityJPA.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="User")
@Table
@Getter
@Setter


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;

}
