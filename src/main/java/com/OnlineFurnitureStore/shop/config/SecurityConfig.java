package com.OnlineFurnitureStore.shop.config;

import com.OnlineFurnitureStore.shop.JWT.JwtTokenFilterConfigurer;
import com.OnlineFurnitureStore.shop.Handler.UnauthorizedHandler;
import com.OnlineFurnitureStore.shop.JWT.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UnauthorizedHandler unauthorizedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .cors().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/authentication/**").permitAll()
//                .antMatchers("/api/admin/scripts/**").permitAll()
                .anyRequest().authenticated();

        httpSecurity.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
        httpSecurity.httpBasic();

        httpSecurity
                .headers()
                .contentTypeOptions()
                .disable()
                .frameOptions()
                .sameOrigin();
    }
}