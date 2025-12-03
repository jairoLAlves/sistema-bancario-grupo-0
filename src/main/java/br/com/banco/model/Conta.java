package br.com.banco.model;

public abstract class Conta {

    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Depósito de R$ "+ valor +" realizado com sucesso! na conta de "+ this.titular);
        }
    }

    public boolean sacar(double valor){
        if (valor > 0 && this.saldo >= valor){
            this.saldo -= valor;
            System.out.println("Saque de R$ "+valor+" realizado na conta de "+this.titular+" com sucesso!");
            return true;

        }else{
            System.out.println("Saldo insuficiente para saque! na conta de "+this.titular);
            return false;
        }

    }

    public void transferir(double valor, Conta destino){

        if(destino instanceof ContaSalario){
            System.out.println("Operação cancelada: Não é permitido transferir valores para uma conta Salário.");
            return;
        }

        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ "+valor+" realizada de "+this.titular+" para "+destino.titular+" com sucesso!");
        }else{
            System.out.println("Transferência falhou: Saldo insuficiente.");

        }


    }

    public void exibirSaldo(){
        System.out.printf("Conta: %s | Saldo: R$ %.2f%n", this.titular, this.saldo);
    }








}
