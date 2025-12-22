package br.com.banco.validations;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SenhaValidation {

    @Size(min = 4 , message = "A Senha deve ter no mínimo 4 carácter.")
    @Size(max = 30 , message = "A Senha deve ter no máximo 30 carácter.")
    @NotBlank(message = "A Senha não pode ser vazia.")
    @NotNull(message = "A Senha não pode ser nula.")
    private final String senha;

    public SenhaValidation(String senha) {
        this.senha = senha;
        Validador.validar(this);
    }
    public String getSenha() {
        return senha;
    }

}
