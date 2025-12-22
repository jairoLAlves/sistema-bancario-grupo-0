package br.com.banco.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Titular{
    private final String nome;
    private final String cpf;
    private final String senha;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    public Titular(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        // TODO - Verificar senha tratar e lançar exceções -> PasswordException
        this.senha = passwordEncoder.encode(senha);
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return   cpf;
    }

    public String getSenha() {
        return senha;
    }


    @Override
    public String toString() {
        return "Titular{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
