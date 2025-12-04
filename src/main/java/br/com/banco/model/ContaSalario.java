package br.com.banco.model;

public class ContaSalario extends Conta {

    public ContaSalario(String titular) {
        super(titular);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Salário.");
            return true;
        } else {
            System.out.println("Saldo insuficiente na Conta Salário.");
            return false;
        }
    }

    // Conta Salário não tem métodos extras nem cheque especial.
}
