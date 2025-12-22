package br.com.banco.model;

import br.com.banco.enums.Status;

public class Results {

    private String msg;
    private Status status;

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    private Conta conta;

    public Results(String msg, Status status, Conta conta) {
        this.msg = msg;
        this.status = status;
        this.conta = conta;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public  Results(){}



}
