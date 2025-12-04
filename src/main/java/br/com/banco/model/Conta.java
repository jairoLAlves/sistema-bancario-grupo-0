package br.com.banco.model;

public abstract class Conta {
    // Encapsulamento: atributos protected permitem acesso pelas subclasses
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Método abstrato: obriga as subclasses a implementarem sua própria lógica de saque
    public abstract boolean sacar(double valor);

    // Método concreto: igual para todas (exceto se quiséssemos regras específicas)
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado na conta de " + this.titular);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Lógica de transferência com verificação de tipo (instanceof)
    public void transferir(double valor, Conta destino) {
        // Regra: Conta Salário não pode ser destino
        if (destino instanceof ContaSalario) {
            System.out.println("ERRO: Não é permitido transferir valores para uma Conta Salário.");
            return;
        }

        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso para " + destino.titular);
        } else {
            System.out.println("Falha na transferência: Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Conta de: " + this.titular + " | Saldo Atual: R$ " + String.format("%.2f", this.saldo));
    }

    public String getTitular() {
        return titular;
    }
}