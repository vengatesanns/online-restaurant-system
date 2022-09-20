package com.hackprotech.securityservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    public static final int ROUNDS = 15;

    @Autowired
    private CustomCorsConfigurationSource customCorsConfigurationSource;


    // @formatter:off
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().configurationSource(customCorsConfigurationSource)
                .and()
                .authorizeRequests()
                .antMatchers("/token", "/user/sign-up", "/user/profile/update")
                .permitAll()
                .antMatchers("/user/**")
                .authenticated()
                .and()
                .csrf().disable()
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .httpBasic();
        return httpSecurity.build();
    }
    // @formatter:on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(ROUNDS);
    }


}
