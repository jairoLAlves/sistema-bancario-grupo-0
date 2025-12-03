package br.com.banco.model;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(String titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * this.taxaRendimento;
        this.saldo += rendimento;
        System.out.printf("Rendimento de R$ %.2f aplicado na conta de %s%n", rendimento, this.titular);
    }
}



