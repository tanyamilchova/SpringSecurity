package com.exampleWebSecurityDB.WebSecurityDB.controller;

import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.LoginDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.RegisterAuthDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.RegisterDTO;
import com.exampleWebSecurityDB.WebSecurityDB.model.DTOs.UserWithoutPassDTO;
import com.exampleWebSecurityDB.WebSecurityDB.service.AuthorityService;
import com.exampleWebSecurityDB.WebSecurityDB.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;
import java.util.Optional;
@RestController
public class HomeResource {
    @Autowired
    UserService userService;
    @Autowired
    AuthorityService authorityService;
//    @PostMapping("/logina")
//    public UserWithoutPassDTO login(@RequestBody LoginDTO loginData, HttpSession session){
//        UserWithoutPassDTO u=userService.login(loginData);
//        session.setAttribute(Util.LOGGED, true);
//        session.setAttribute(Util.LOGGED_ID, u.getId());
//
//        return u;
//    }
    @GetMapping("/users/{id}")
    public UserWithoutPassDTO getById(@PathVariable int id){
        return userService.getById(id);
    }

        @GetMapping("/")
        public String home(){
            return ("<h1>WelcomeDear</h1>");
        }
        @GetMapping("/about")
        public String about(){
            return ("<h1>Welcome! Enjoy our application! </h1>");
        }
    @PostMapping("/register")
    public UserWithoutPassDTO register(@RequestBody RegisterDTO registerData){
        return userService.register(registerData);
    }
    @PostMapping("/registerauth")
    public RegisterAuthDTO registerAuth(@RequestBody RegisterAuthDTO registerAuthDTO){
        return authorityService.authRegister(registerAuthDTO);
    }
//        @GetMapping("/userId/{1}")
//        public String userBuId(@PathVariable int id){
//            Optional<User> opt=userRepository.findById(id);
//            if(opt.isPresent()) {
//                String name = opt.get().getUsername();
//            }
//            return "No such user";
//
//        }
        @GetMapping("/admin")
        public String admin(){
            return ("<h1>Welcome Admin</h1>");
        }
        @GetMapping("/user")
        public String user(){
            return ("<h1>Welcome User</h1>");
        }
}
