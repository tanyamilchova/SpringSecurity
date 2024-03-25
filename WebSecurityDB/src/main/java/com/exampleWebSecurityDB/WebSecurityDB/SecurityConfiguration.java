package com.exampleWebSecurityDB.WebSecurityDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
        @Autowired
        DataSource dataSource;

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource);
//            .withDefaultSchema()
//            .withUser(User.withUsername("user").password("pass").roles("USER"))
//            .withUser(User.withUsername("admin").password("pass").roles("ADMIN"));
        }
        @Bean
        public SecurityFilterChain configure(HttpSecurity http)throws Exception{
            return http
                    .csrf(csrf->csrf.disable())
                    .authorizeHttpRequests((r)->{

                        r.requestMatchers("/admin").hasRole("ADMIN");
                        r.requestMatchers("/user").hasAnyRole("ADMIN","USER");
                        r.requestMatchers("/").permitAll();
                        r.requestMatchers("/about").permitAll();
                        r.requestMatchers("/register").permitAll();
                        r.requestMatchers("/registerauth").permitAll();
                    })
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }
        @Bean
        public PasswordEncoder getPasswordEncoder(){
            return NoOpPasswordEncoder.getInstance();
        }
}

