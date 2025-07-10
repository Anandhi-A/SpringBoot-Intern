package com.example.springbootfirst.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableMethodSecurity
@Configuration
public class SpringConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf((CsrfConfigurer<HttpSecurity> csrf)-> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.DELETE,"/stud").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT,"/stud").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.POST,"/stud").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN","USER");
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults());

        return http.build();

    }
    @Bean
    UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
                .username("Aadhithya")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails sana = User.builder()
                .username("aadhi")
                .password(passwordEncoder().encode("sana123"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin,sana);
    }

}
