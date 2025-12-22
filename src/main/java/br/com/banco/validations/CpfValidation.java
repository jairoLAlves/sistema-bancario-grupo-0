package br.com.banco.validations;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class CpfValidation {

    @NotBlank(message = "A CPF não pode ser vazio.")
    @NotNull(message = "A CPF não pode ser nula.")
    @Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
     // TODO - remover para funcionar com CPFs validos |  @CPF(message = "CPF inválido")
    private final String cpf;

    public CpfValidation(String cpf) {
        this.cpf = cpf;
        Validador.validar(this);
    }
    public String getSenha() {
        return cpf;
    }
}
