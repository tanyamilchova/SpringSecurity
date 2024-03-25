package com.exampleSpringSecurityJPA.SpringSecurityJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    UserDetailsService userDetailService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);

    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http)throws Exception{
        return http
                .authorizeHttpRequests((r)->{

                    r.requestMatchers("/admin").hasRole("ADMIN");
                    r.requestMatchers("/user").hasAnyRole("ADMIN","USER");
                    r.requestMatchers("/").permitAll();
                    r.requestMatchers("/about").permitAll();
                })
                .formLogin(Customizer.withDefaults())
                .build();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
