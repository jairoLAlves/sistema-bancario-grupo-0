package br.com.banco.model;

import br.com.banco.enums.ContaT;
import br.com.banco.enums.Operacao;
import br.com.banco.exceptions.OperacaoInvalida;

public class ContaCorrente extends Conta {

    protected double limiteChequeEspecial = 100;

    public ContaCorrente(Titular titular, double limiteChequeEspecial, ContaT tipo) {
        super(titular, tipo);
        if(limiteChequeEspecial > 0 && limiteChequeEspecial <= 500){
            this.limiteChequeEspecial = limiteChequeEspecial;
        }
    }

    @Override
    public void sacar(double valor, Boolean isTransferido) {
        double saldoDisponivel = this.saldo + this.limiteChequeEspecial;

        if( valor > 0 && valor <= saldoDisponivel ){


            this.saldo -= valor;

            if(!isTransferido){
                this.adicionarTransacao(
                        Operacao.DEBITO,
                        "Saque de R$: " + valor + " realizado na Conta Corrente.",
                        valor
                );
            }





        } else{
            throw new OperacaoInvalida("Falha na transferência: Saldo insuficiente.");
        }

    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }




}
