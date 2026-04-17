package com.dm3.security.controllers;

import com.dm3.security.DTO.UsuarioRequestDTO;
import com.dm3.security.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("users")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioRequestDTO dto){
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }

    @GetMapping("/admin")
    public String admin(){
        return "Acesso ADMIN";
    }
}
