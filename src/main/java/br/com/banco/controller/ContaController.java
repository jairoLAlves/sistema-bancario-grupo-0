package br.com.banco.controller;

import br.com.banco.enums.Status;
import br.com.banco.exceptions.ContaEx;
import br.com.banco.exceptions.OperacaoInvalida;
import br.com.banco.model.Conta;
import br.com.banco.model.Results;
import br.com.banco.services.ContaService;
import br.com.banco.validations.CpfValidation;
import br.com.banco.validations.SenhaValidation;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
import java.util.UUID;

public class ContaController {

    private final ContaService service = new ContaService();


    public Results autenticar(Object id, String senha){
        var results = new Results();
        Conta conta = null;

        try {

            new SenhaValidation(senha);



            if (id instanceof UUID uuidId) {

                conta = service.autenticar(uuidId, senha);

            } else if (id instanceof String cpf) {

                new CpfValidation(cpf);

                conta = service.autenticar(cpf, senha);

            } else {
                throw new ContaEx("Tipo de ID não suportado");
            }

            results.setConta(conta);
            results.setStatus(Status.SUCCESS);
            results.setMsg("Usuário autenticado com sucesso!");


            return results;


        } catch (ContaEx | OperacaoInvalida  e) {
            results.setConta(conta);
            results.setStatus(Status.INFO);
            results.setMsg(e.getMessage());
            return results;

        }catch (Exception e){
            results.setConta(conta);
            results.setStatus(Status.ERROR);
            results.setMsg("Erro na aplicação.");
            e.printStackTrace();

            return results;

        }


    }


    public Results transferir(Conta origem, Object id, double valor){
        var results = new Results();

        try {

            if (id instanceof UUID uuidId) {
                service.transferir(origem, uuidId, valor);
            } else if (id instanceof String cpf) {
                 service.transferir(origem, cpf, valor);
            } else {
                throw new ContaEx("Tipo de ID não suportado");
            }

            results.setConta(null);
            results.setStatus(Status.SUCCESS);
            results.setMsg("Transferência realizada com sucesso!");

            return results;


        } catch (ContaEx | OperacaoInvalida e) {
            results.setConta(null);
            results.setStatus(Status.INFO);
            results.setMsg(e.getMessage());
            return results;

        } catch (Exception e){
            results.setConta(null);
            results.setStatus(Status.ERROR);
            results.setMsg("Erro na aplicação.");
            e.printStackTrace();

            return results;

        }

    }


    public Results depositar(Conta conta, double valor, String descricao){
        var results = new Results();

        try {

            service.depositar(conta, valor, descricao);

            results.setConta(null);
            results.setStatus(Status.SUCCESS);
            results.setMsg("Depósito realizada com sucesso!");

            return results;


        } catch (ContaEx | OperacaoInvalida e) {
            results.setConta(null);
            results.setStatus(Status.INFO);
            results.setMsg(e.getMessage());
            return results;

        } catch (Exception e){
            results.setConta(null);
            results.setStatus(Status.ERROR);
            results.setMsg("Erro na aplicação.");
            e.printStackTrace();

            return results;

        }
    }


    public Results sacar(Conta conta, double valor){
        var results = new Results();

        try {

            service.sacar(conta, valor);

            results.setConta(null);
            results.setStatus(Status.SUCCESS);
            results.setMsg("Saque realizada com sucesso!");

            return results;


        } catch (ContaEx | OperacaoInvalida e) {
            results.setConta(null);
            results.setStatus(Status.INFO);
            results.setMsg(e.getMessage());
            return results;

        } catch (Exception e){
            results.setConta(null);
            results.setStatus(Status.ERROR);
            results.setMsg("Erro na aplicação.");
            e.printStackTrace();

            return results;

        }
    }

    public List<Conta> buscarPorCpf(String cpf){

      return service.getContasCpf(cpf);

    }

    public List<Conta> getContas(){

        return service.getContas();

    }







}
