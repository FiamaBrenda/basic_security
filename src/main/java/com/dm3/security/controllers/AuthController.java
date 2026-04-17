package com.dm3.security.controllers;

import com.dm3.security.DTO.LoginDTO;
import com.dm3.security.services.JwtService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getSenha()
                )
        );
        return jwtService.gerarToken(loginDTO.getEmail());
    }
}
