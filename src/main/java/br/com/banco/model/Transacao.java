package br.com.banco.model;

import br.com.banco.enums.Operacao;

import java.time.LocalDateTime;

public class Transacao {
    private final LocalDateTime data;
    private final String  descricao;
    private final Double valor;
    private final Operacao operacao;

    public Transacao(LocalDateTime data, String descricao, Double valor, Operacao operacao) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.operacao = operacao;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", operacao=" + operacao +
                '}';
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Operacao getOperacao() {
        return operacao;
    }
}
