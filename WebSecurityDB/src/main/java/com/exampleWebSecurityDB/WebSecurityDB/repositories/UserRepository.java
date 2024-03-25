package com.exampleWebSecurityDB.WebSecurityDB.repositories;

import com.exampleWebSecurityDB.WebSecurityDB.entities.Authority;
import com.exampleWebSecurityDB.WebSecurityDB.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findById(int id);

    Optional<User> findByUsername(String username);
}
