package com.exampleWebSecurityDB.WebSecurityDB.service;

import com.exampleWebSecurityDB.WebSecurityDB.entities.Authority;
import com.exampleWebSecurityDB.WebSecurityDB.entities.User;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.RegisterAuthDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.UserWithoutPassDTO;
import com.exampleWebSecurityDB.WebSecurityDB.repositories.AuthorityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    ModelMapper mapper;
    public RegisterAuthDTO authRegister(RegisterAuthDTO registerAuthDTO) {

        Authority authority  = mapper.map(registerAuthDTO, Authority.class);
        authorityRepository.save(authority);
        return mapper.map(authority, RegisterAuthDTO.class);
    }
}
