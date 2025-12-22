package br.com.banco.repository;

import br.com.banco.enums.ContaT;
import br.com.banco.exceptions.ContaEx;
import br.com.banco.model.*;

import java.util.*;
import java.util.stream.Collectors;


import static br.com.banco.enums.ContaT.*;

public class ContasRepository{

    // Instância única (Singleton) para toda a app acessar os mesmos dados
    private static ContasRepository instance;

    private LinkedList<Conta> contas =  new LinkedList<>();

    private ContasRepository() {
        inicializarDadosFalsos();
    }

    public static ContasRepository getInstance() {
        if (instance == null) {
            instance = new ContasRepository();
        }
        return instance;
    }

    // GERAÇÃO DE DADOS MOCKADOS
    private void inicializarDadosFalsos() {


        criarContaMock("João Silva",
                "11111111111",
                "senha123",
                5000.0,
                POUPANCA

        );

        // Contas de Terceiros (Para testar transferência)
        criarContaMock("Maria Oliveira",
                "22222222222",
                "senha1234",
                2500.0,
                SALARIO

        );

        criarContaMock("Carlos Souza",
                "33333333333",
                "senha12345",
                100.0,
                CORRENTE
        );
        criarContaMock("Ana Pereira",
                "44444444444",
                "senha123456",
                15000.0,
                POUPANCA
        );
    }

    private void criarContaMock(String nome, String cpf, String senha, double saldoInicial, ContaT tipo) {

        Titular titular = new Titular(nome, cpf, senha);

        Conta c = switch (tipo){
            case CORRENTE -> new ContaCorrente(titular, 250 ,tipo);
            case POUPANCA -> new ContaPoupanca(titular, 0,tipo);
            case SALARIO -> new ContaSalario(titular, tipo);
        };

        c.depositar(saldoInicial, null);
        contas.add(c);
    }


    public Boolean isIn(Conta conta){
        return contas.contains(conta);
    }
    public Optional<Conta>  buscarPorNumero(UUID numConta) {

        if (numConta == null) {
            throw new ContaEx("Número da conta não pode ser nulo.");
        }
        return contas.stream().filter(c ->  numConta.equals(c.getNumeroConta()))
                .findFirst();
    }

    public Optional<Conta> buscarPorCpf(String cpf) {


        return contas.stream().filter(c ->  cpf.equalsIgnoreCase(c.getTitular().getCpf()))
                .findFirst();

    }

    public Optional<Conta>  buscarPorNome(String nome) {
        return contas.stream().filter(c ->  nome.equalsIgnoreCase(c.getTitular().getNome()))
                .findFirst();

    }

    public List<Conta> getContas() {
        return contas;
    }

    public List<Conta> getContasCpf(String cpf){
        return contas.stream().filter(conta -> conta.getTitular().getCpf().contains(cpf)).collect(Collectors.toList());
    }
}