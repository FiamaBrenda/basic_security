package com.dm3.security.services;

import com.dm3.security.DTO.UsuarioRequestDTO;
import com.dm3.security.entities.Usuario;
import com.dm3.security.entities.enums.Role;
import com.dm3.security.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(PasswordEncoder passwordEncoder, UsuarioRepository usuarioRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setRole(Role.ROLE_USER);
        usuarioRepository.save(usuario);
        return usuario ;
    }
}
