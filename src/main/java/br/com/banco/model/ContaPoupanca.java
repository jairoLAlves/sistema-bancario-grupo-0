package br.com.banco.model;

public class ContaPoupanca extends Conta {
    private double taxaRendimento; // Ex: 0.05 para 5%

    public ContaPoupanca(String titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Poupança.");
            return true;
        } else {
            System.out.println("Saldo insuficiente na Poupança.");
            return false;
        }
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * this.taxaRendimento;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$ " + String.format("%.2f", rendimento) + " aplicado.");
    }
}



