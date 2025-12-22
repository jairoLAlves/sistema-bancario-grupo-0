package br.com.banco.services;

import br.com.banco.exceptions.ContaEx;
import br.com.banco.exceptions.OperacaoInvalida;
import br.com.banco.model.Conta;
import br.com.banco.repository.ContasRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

public class ContaService {
    private ContasRepository db = ContasRepository.getInstance();
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Conta autenticar(UUID numeroConta, String senha) throws ContaEx, OperacaoInvalida {

        Conta conta = db.buscarPorNumero(numeroConta).orElseThrow(()-> new ContaEx("Conta não encontrada."));

        if (!passwordEncoder.matches(senha, conta.getTitular().getSenha()) ) {
            throw new ContaEx("Senha incorreta.");
        }

        return conta;
    }

    public Conta autenticar(String cpf, String senha) throws ContaEx, OperacaoInvalida  {

        Conta conta = db.buscarPorCpf(cpf).orElseThrow(()-> new ContaEx("Conta não encontrada."));

        if (!passwordEncoder.matches(senha, conta.getTitular().getSenha())) {
            throw new ContaEx("Senha incorreta.");
        }

        return conta;
    }

    public void transferir(Conta origem, UUID numeroContaDestino, double valor) throws ContaEx, OperacaoInvalida  {

        Conta destino = buscarPorNumero(numeroContaDestino);

        origem.transferir(valor, destino);

    }

    public void transferir(Conta origem, String cpf, double valor) throws ContaEx, OperacaoInvalida  {

        Conta destino = buscarPorCpf(cpf);

        origem.transferir(valor, destino);

    }

    public void depositar(Conta conta, double valor, String descricao) throws ContaEx, OperacaoInvalida {

        boolean exist = db.isIn(conta);

        if(!exist){
            throw new ContaEx("Conta de outro Banco!");

        }

        conta.depositar(valor, descricao);


    }

    public void sacar(Conta conta, double valor) throws ContaEx, OperacaoInvalida  {

        boolean exist = db.isIn(conta);

        if(!exist){
            throw new ContaEx("Conta de outro Banco!");

        }

        conta.sacar(valor, false);





    }

    private Conta buscarPorCpf(String cpf) throws ContaEx {

        Conta conta = db.buscarPorCpf(cpf)
                .orElseThrow(()-> new ContaEx("Conta inexistente."));

        return conta;

    }

    public List<Conta> getContasCpf(String cpf) {
        return db.getContasCpf(cpf);
    }

    public List<Conta> getContas() {
        return db.getContas();
    }

    private Conta buscarPorNumero(UUID numeroContaDestino) throws ContaEx, OperacaoInvalida {

        Conta conta = db.buscarPorNumero(numeroContaDestino)
                .orElseThrow(()-> new ContaEx("Conta  inexistente."));

        return conta;

    }









}
