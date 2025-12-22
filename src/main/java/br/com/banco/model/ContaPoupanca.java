package br.com.banco.model;

import br.com.banco.enums.ContaT;
import br.com.banco.enums.Operacao;
import br.com.banco.exceptions.OperacaoInvalida;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends Conta {

    protected double taxaRendimento = 0.05; // Ex: 0.05 para 5%

    public ContaPoupanca(Titular titular, double taxaRendimento, ContaT tipo) {
        super(titular, tipo);

        if(taxaRendimento > 0 && taxaRendimento <= 0.1 ){
            this.taxaRendimento = taxaRendimento;
        }

    }

    @Override
    public void sacar(double valor, Boolean isTransferido) {
        if(valor > 0 && valor <= this.saldo){
            this.saldo -= valor;

            if(!isTransferido) {
                this.adicionarTransacao(
                        Operacao.DEBITO,
                        "Saque de R$: " + valor + " realizado na Conta Poupança.",
                        valor
                );
            }


        } else{
            throw new OperacaoInvalida("Falha na transferência: Saldo insuficiente.");
        }
    }

    public double rendimento() {

        /**
         * TODO - Obter a ultima Transação do tipo APLICAR_RENDIMENTO pegar a  sua data  calcular o rendimento
         * se não tiver Transação desse tipo pegar a partir do dataCriacao
         * atribuir ao saldo
         * Adicionar uma nova Transação do tipo APLICAR_RENDIMENTO
         */


        long mesesDecorridos = ChronoUnit.MONTHS.between(dataCriacao, LocalDateTime.now());

        if (mesesDecorridos <= 0) {
            return 0.0;
        }
        // Aplica Juros Compostos: Saldo * (1 + taxa)^meses
        double montanteFinal = this.saldo * Math.pow(1 + taxaRendimento, mesesDecorridos);

        double rendimento = montanteFinal - this.saldo;

        return rendimento;

    }




}



