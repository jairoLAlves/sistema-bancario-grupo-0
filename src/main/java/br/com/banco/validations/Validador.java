package br.com.banco.validations;

import br.com.banco.exceptions.ContaEx;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

public class Validador {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static <T> void validar(T objeto) {
        Set<ConstraintViolation<T>> violacoes = validator.validate(objeto);

        if (!violacoes.isEmpty()) {
            // Pega todas as mensagens de erro e junta em uma String só
            String erros = violacoes.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));

            // Lança uma exceção que o seu Controller JavaFX vai pegar
            throw new ContaEx(erros);
        }
    }
}