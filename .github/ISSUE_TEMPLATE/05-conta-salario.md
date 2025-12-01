---
name: 05. Implementar Conta Salário
about: Desenvolvimento da Conta Salário (Restrita)
title: "[FEAT] Classe ContaSalario"
labels: backend, feature
assignees: ''
---

**Objetivo:** Criar a conta salário herdando de Conta.

**Requisitos Técnicos:**
- [ ] Herdar de `Conta`.
- [ ] Sobrescrever `sacar(valor)`: Apenas se tiver saldo.
- [ ] **Restrição:** Garantir que NÃO possua métodos de rendimento nem cheque especial.
- [ ] Testar se a classe `Conta` (base) está bloqueando transferências para esta conta.