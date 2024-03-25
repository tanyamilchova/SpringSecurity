package com.exampleSpringSecurityExample.SpringSecurityExample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
    @GetMapping("/")
    public String home(){
        return ("<h1>WelcomeDear</h1>");
    }
    @GetMapping("/about")
    public String about(){
        return ("<h1>Welcome! Enjoy our application! </h1>");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome Admin</h1>");
    }
    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }
}
