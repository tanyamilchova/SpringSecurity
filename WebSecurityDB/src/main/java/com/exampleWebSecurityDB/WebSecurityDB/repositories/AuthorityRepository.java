package com.exampleWebSecurityDB.WebSecurityDB.repositories;

import com.exampleWebSecurityDB.WebSecurityDB.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
//    Optional<Authority>findById(int id);
}
