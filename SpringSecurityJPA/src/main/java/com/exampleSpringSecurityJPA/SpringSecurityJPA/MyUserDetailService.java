package com.exampleSpringSecurityJPA.SpringSecurityJPA;

import com.exampleSpringSecurityJPA.SpringSecurityJPA.model.User;
import com.exampleSpringSecurityJPA.SpringSecurityJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
   @Autowired
   UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUserName(userName);
    if(user.isPresent()){
        System.out.println(user.get().getUserName()+" name");
        System.out.println(user.get().getRoles()+" role");
        System.out.println(user.get().getPassword()+" password");
    }
    user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
    return user.map(MyUserDetails::new).get();
}
}
