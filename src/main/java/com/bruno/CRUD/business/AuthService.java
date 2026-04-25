package com.bruno.CRUD.business;

import com.bruno.CRUD.business.dtos.in.LoginRequest;
import com.bruno.CRUD.business.dtos.in.RegisterRequest;
import com.bruno.CRUD.business.dtos.out.LoginResponse;
import com.bruno.CRUD.infrastructure.entity.Usuario;
import com.bruno.CRUD.infrastructure.repository.UsuarioRepository;
import com.bruno.CRUD.infrastructure.security.JwtService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.encoder = new BCryptPasswordEncoder();
    }


    public LoginResponse login(LoginRequest request) {

        String email = request.getEmail();
        String senha = request.getSenha();


        if (email == null || senha == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(senha, usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        // buscar no baco depois

        String token = jwtService.generateToken(usuario.getEmail());
        return new LoginResponse(token);
    }

    public void register(RegisterRequest request) {
        String email = request.getEmail();
        String senha = request.getSenha();

        if (email == null || senha == null) {
            throw new RuntimeException("Dados inválidos");
        }

        if (usuarioRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Usuário já existe");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(encoder.encode(senha));

        usuarioRepository.save(usuario);

    }


}
