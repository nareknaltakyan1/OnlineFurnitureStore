package com.OnlineFurnitureStore.shop.JWT;

import com.OnlineFurnitureStore.shop.Entity.User;
import com.OnlineFurnitureStore.shop.Exception.CustomException;
import com.OnlineFurnitureStore.shop.Repository.UserRepository;
import com.auth0.jwt.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${security.token.header}")
    private String tokenHeader;

    @Autowired
    private UserRepository UserRepository;

    Authentication getAuthentication(String token) {
        String username = getUsername(token);
        User user = UserRepository.findByName(username);

        return new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities());
    }

    public String getUsername(String token) {
        return JWT.decode(token).getClaim("username").asString();
    }

    String resolveToken(HttpServletRequest req) {
        return req.getHeader(tokenHeader);
    }

    boolean validateToken(String token) {
        CustomException illegalCustomException = new CustomException("Expired or invalid JWT token", HttpStatus.UNAUTHORIZED);
        CustomException forbiddenCustomException = new CustomException("Access Denied", HttpStatus.UNAUTHORIZED);

        try {
            if (JWT.decode(token).getExpiresAt().before(new Date()))
                throw illegalCustomException;
            return true;
        } catch (Exception ex) {
            throw forbiddenCustomException;
        }
    }

}