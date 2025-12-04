package br.com.banco.model;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String titular, double limiteChequeEspecial) {
        super(titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        double saldoDisponivel = this.saldo + this.limiteChequeEspecial;

        if (valor > 0 && valor <= saldoDisponivel) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado na Conta Corrente.");
            return true;
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial) para saque de R$ " + valor);
            return false;
        }
    }

    @Override
    public void exibirSaldo() {
        super.exibirSaldo();
        System.out.println(" -> Limite Cheque Especial: R$ " + this.limiteChequeEspecial);
        System.out.println(" -> Saldo Total Disponível: R$ " + (this.saldo + this.limiteChequeEspecial));
    }
}
