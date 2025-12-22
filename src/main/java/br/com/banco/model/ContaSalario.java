package br.com.banco.model;

import br.com.banco.enums.ContaT;
import br.com.banco.enums.Operacao;
import br.com.banco.exceptions.OperacaoInvalida;

public class ContaSalario extends Conta {

    public ContaSalario(Titular titular, ContaT tipo) {
        super(titular, tipo);
    }

    @Override
    public void sacar(double valor, Boolean isTransferido) {
        if(valor > 0 && valor <= this.saldo){
            this.saldo -= valor;

            if(!isTransferido) {
                this.adicionarTransacao(
                        Operacao.DEBITO,
                        "Saque de R$: " + valor + " realizado na Conta Salário.",
                        valor
                );
            }


        }else{
            throw new OperacaoInvalida("Falha na transferência: Saldo insuficiente.");
        }
    }

}
