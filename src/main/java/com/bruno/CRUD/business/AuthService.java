package com.bruno.CRUD.business;

import com.bruno.CRUD.business.dtos.in.LoginRequest;
import com.bruno.CRUD.business.dtos.in.RegisterRequest;
import com.bruno.CRUD.business.dtos.out.LoginResponse;

public class AuthService {

    public LoginResponse login (LoginRequest request) {

        String email = request.getEmail();
        String senha = request.getSenha();

        if (email == null || senha == null) {
            throw new RuntimeException("Dados inválidos");
        }

        // buscar no baco depois

        return new LoginResponse("token-fake");
    }

    public void registrar (RegisterRequest request){
        String email = request.getEmail();
        String senha = request.getSenha();

        if  (email == null || senha == null){
            throw new RuntimeException("Dados inválidos");
        }

    }

}
