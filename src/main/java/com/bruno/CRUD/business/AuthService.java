package com.bruno.CRUD.business;

import com.bruno.CRUD.business.dtos.in.LoginRequest;
import com.bruno.CRUD.business.dtos.in.RegisterRequest;
import com.bruno.CRUD.business.dtos.out.LoginResponse;
import com.bruno.CRUD.infrastructure.entity.Usuario;
import com.bruno.CRUD.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public LoginResponse login(LoginRequest request) {

        String email = request.getEmail();
        String senha = request.getSenha();

        if (email == null || senha == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!usuario.getSenha().equals(request.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        // buscar no baco depois

        return new LoginResponse("token-fake");
    }

    public void registrar(RegisterRequest request) {
        String email = request.getEmail();
        String senha = request.getSenha();

        if (email == null || senha == null) {
            throw new RuntimeException("Dados inválidos");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setSenha(request.getSenha());

        usuarioRepository.save(usuario);

    }


}
