package br.com.banco.model;

public class ContaSalario extends Conta{

    public ContaSalario(String titular) {
        super(titular);
    }
    // Conta Salário usa o sacar padrão (não tem cheque especial)

}
