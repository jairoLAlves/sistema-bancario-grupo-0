package br.com.banco.model;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String titular, double limiteChequeEspecial) {
        super(titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        // Verifica se o valor é coberto pelo saldo + limite
        if (valor > 0 && (this.saldo + this.limiteChequeEspecial) >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado (Conta Corrente) de " + this.titular);
            return true;
        } else {
            System.out.println("Saque insucesso na conta de " + this.titular + " (Saldo + Limite insuficientes)");
            return false;
        }
    }
}
