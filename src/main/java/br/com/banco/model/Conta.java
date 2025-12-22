package br.com.banco.model;

import br.com.banco.enums.ContaT;
import br.com.banco.enums.Operacao;
import br.com.banco.exceptions.ContaEx;
import br.com.banco.exceptions.OperacaoInvalida;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Conta {

    private final UUID numeroConta;
    protected final Titular titular;
    protected final ContaT tipo;
    protected double saldo;
    protected final  LocalDateTime dataCriacao;
    protected final List<Transacao> extrato;

    public Conta(Titular titular, ContaT tipo) {
        this.tipo = tipo;
        this.numeroConta = UUID.randomUUID();
        this.dataCriacao = LocalDateTime.now();
        this.titular = titular;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public abstract void sacar(double valor, Boolean isTransferido) throws OperacaoInvalida;

    public void depositar(double valor, String descricao) throws OperacaoInvalida {

        if(valor > 0){
            this.saldo += valor;
            this.adicionarTransacao(
                    Operacao.CREDITO,
                    (descricao == null || descricao.isBlank())
                            ? "Depósito em Cáixa" : descricao,
                    valor);

        }else{
            throw new OperacaoInvalida(String.format("Valor de depósito inválido: %.2f, Data: %s", valor, LocalDateTime.now()));
        }


    }
    public void transferir(double valor, Conta destino) throws OperacaoInvalida {

        if (destino == null) throw new OperacaoInvalida("Destinatário inexistente.");

        if (destino.numeroConta.equals(this.getNumeroConta())) throw new OperacaoInvalida("Não pode transferir para si mesmo.");


        if(destino instanceof ContaSalario){
            throw new OperacaoInvalida("ERRO: Não é permitido transferir valores para uma Conta Salário.");
        }

        this.sacar(valor, true);

        destino.depositar(valor, "Transferência de: " + this.numeroConta);

        this.adicionarTransacao(
                    Operacao.DEBITO,
                    "Transferência para: " +destino.getTitular().getNome() +" : " + destino.numeroConta,
                    valor
            );



    } ;

    public double getSaldo() {
        return saldo;
    }

    public void adicionarTransacao(Operacao tipo, String descricao, double valor) throws OperacaoInvalida {
        this.extrato.add(new Transacao(LocalDateTime.now(), descricao, valor, tipo));
    }

    public Titular getTitular(){return this.titular;}
    public UUID getNumeroConta(){return this.numeroConta;}
    public ContaT getTipo(){
        return this.tipo;
    }

    public List<Transacao> getExtrato(){
        return List.copyOf(extrato);
    }


}