package com.example.demo.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebSecurity {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http
            .csrf().disable()
            .formLogin()
            .and().authorizeRequests().anyRequest().authenticated()
            .and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        /*  String roleName = "ROLE_ADMIN";
        List<String> permissions = new ArrayList<String>();
        permissions.add("CREATE");
        permissions.add("READ");
        permissions.add("UPDATE");
        permissions.add("DELETE");
        //Role roleAdmin=*/

        var user1 = User.withUsername("rodrigo").password("12345").authorities("admin").build();

        var uds = new InMemoryUserDetailsManager();
        uds.createUser(user1);
        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance(); //n dá encode, so para testar
    }


}
