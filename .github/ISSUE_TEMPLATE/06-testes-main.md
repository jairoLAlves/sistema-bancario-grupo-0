---
name: 06. Testes e Classe Main
about: Criar a execução principal para demonstrar o sistema
title: "[TEST] Implementar Main.java e Cenários"
labels: teste, demo
assignees: ''
---

**Objetivo:** Criar a classe `Main` para validar todas as regras do trabalho.

**Cenários de Teste Obrigatórios:**
- [ ] **Criação:** Instanciar 1 Corrente, 1 Poupança, 1 Salário.
- [ ] **Depósitos:** Colocar dinheiro em todas.
- [ ] **Saque Corrente:** Testar saque usando o Cheque Especial.
- [ ] **Saque Poupança/Salário:** Testar saque maior que o saldo (deve falhar).
- [ ] **Transferência Válida:** Corrente -> Poupança.
- [ ] **Transferência Inválida:** Poupança -> Salário (Deve exibir erro).
- [ ] **Rendimento:** Chamar `aplicarRendimento()` na poupança e ver saldo subir.