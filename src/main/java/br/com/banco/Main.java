package br.com.banco;
import br.com.banco.model.ContaCorrente;
import br.com.banco.model.ContaPoupanca;
import br.com.banco.model.ContaSalario;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA BANCÁRIO ===");

        // 1. Criação das Contas
        ContaCorrente cc = new ContaCorrente("João (Corrente)", 500.0); // 500 de cheque especial
        ContaPoupanca cp = new ContaPoupanca("Maria (Poupança)", 0.02); // 2% de rendimento
        ContaSalario cs = new ContaSalario("Pedro (Salário)");

        System.out.println("\n--- DEPÓSITOS INICIAIS ---");
        cc.depositar(1000);
        cp.depositar(1000);
        cs.depositar(1000);

        System.out.println("\n--- TESTE DE SAQUES ---");
        // Saque normal
        cp.sacar(100);
        // Saque usando Cheque Especial (Tem 1000, saca 1200 -> usa 200 do limite)
        cc.sacar(1200);
        // Tentativa de saque maior que saldo na conta salário
        cs.sacar(1500);

        System.out.println("\n--- TESTE DE TRANSFERÊNCIAS ---");
        // Corrente para Poupança (Permitido)
        cc.depositar(500); // Repor saldo
        cc.transferir(200, cp);

        // Poupança para Salário (PROIBIDO)
        cp.transferir(100, cs);

        System.out.println("\n--- RENDIMENTO POUPANÇA ---");
        cp.exibirSaldo();
        cp.aplicarRendimento();
        cp.exibirSaldo();

        System.out.println("\n--- SALDOS FINAIS ---");
        cc.exibirSaldo();
        cp.exibirSaldo();
        cs.exibirSaldo();
    }
}