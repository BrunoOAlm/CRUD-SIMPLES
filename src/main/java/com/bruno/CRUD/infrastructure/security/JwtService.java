package com.bruno.CRUD.infrastructure.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtService {

    private final String SECRET = "sua-chave-secreta";

    public String generateToken(String email){
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(generateExpirationDate())
                .sign(Algorithm.HMAC256(SECRET));

    }

    public void validateToken(String token) {
        JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
        public String getEmailFromToken(String token) {
            return JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token)
                    .getSubject();
        }

    }


