---
name: 04. Implementar Conta Poupança
about: Desenvolvimento da Conta Poupança com Rendimento
title: "[FEAT] Classe ContaPoupanca"
labels: backend, feature
assignees: ''
---

**Objetivo:** Criar a conta poupança herdando de Conta.

**Requisitos Técnicos:**
- [ ] Herdar de `Conta`.
- [ ] Novo atributo: `private double taxaRendimento` (ex: 0.05).
- [ ] Sobrescrever `sacar(valor)`:
    - Não permitir saldo negativo (não tem cheque especial).
- [ ] Método `aplicarRendimento()`:
    - Calcular `saldo * taxaRendimento` e somar ao saldo.