---
name: 03. Implementar Conta Corrente
about: Desenvolvimento da Conta Corrente com Cheque Especial
title: "[FEAT] Classe ContaCorrente"
labels: backend, feature
assignees: ''
---

**Objetivo:** Criar a conta corrente herdando de Conta.

**Requisitos Técnicos:**
- [ ] Herdar de `Conta`.
- [ ] Novo atributo: `private double limiteChequeEspecial`.
- [ ] Construtor: Receber titular e limite.
- [ ] Sobrescrever `sacar(valor)`:
    - Permitir saque se `valor <= saldo + limiteChequeEspecial`.
    - Atualizar saldo (pode ficar negativo).
- [ ] Sobrescrever `exibirSaldo()`: Mostrar saldo atual e quanto resta do limite.