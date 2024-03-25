package com.exampleWebSecurityDB.WebSecurityDB.service;

import com.exampleWebSecurityDB.WebSecurityDB.entities.User;
import com.exampleWebSecurityDB.WebSecurityDB.exceptions.NotFoundException;
import com.exampleWebSecurityDB.WebSecurityDB.exceptions.UnauthorizedException;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.LoginDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.RegisterDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.UserWithoutPassDTO;
import com.exampleWebSecurityDB.WebSecurityDB.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper mapper;
    public <T> T ifPresent(Optional<T> opt){
        if(!opt.isPresent()){
            throw new NotFoundException("Resource not found");
        }
        return opt.get();
    }
    public UserWithoutPassDTO getById(int id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            return mapper.map(opt.get(), UserWithoutPassDTO.class);
        } else {
            throw new NotFoundException("User not found");
        }
    }
    public UserWithoutPassDTO login(LoginDTO loginData) {

        User u=ifPresent(userRepository.findByUsername(loginData.getUsername()));

            return mapper.map(u, UserWithoutPassDTO.class);
    }
    public UserWithoutPassDTO register(RegisterDTO registerData) {
        User u = mapper.map(registerData, User.class);
        userRepository.save(u);
        return mapper.map(u, UserWithoutPassDTO.class);
    }
}

