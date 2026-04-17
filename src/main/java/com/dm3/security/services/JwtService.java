package com.dm3.security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String SECRET = "minhachavesupersecretacommaisde32caracteresparadarcerto";

    public String gerarToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

}
