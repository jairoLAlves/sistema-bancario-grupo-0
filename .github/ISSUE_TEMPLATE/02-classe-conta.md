---
name: 02. Implementar Classe Base (Conta)
about: Criação da classe abstrata que servirá de pai para as outras
title: "[CORE] Criar Classe Abstrata Conta"
labels: backend, core
assignees: ''
---

**Objetivo:** Implementar a superclasse com a lógica compartilhada.

**Requisitos Técnicos:**
- [ ] Definir classe como `public abstract class Conta`.
- [ ] Atributos `protected`: `titular` (String) e `saldo` (double).
- [ ] Construtor: Deve receber e setar o `titular`.
- [ ] Método `depositar(double valor)`: Concreto, soma ao saldo.
- [ ] Método `sacar(double valor)`: **Abstrato** (subclasses devem implementar).
- [ ] Método `transferir(valor, destino)`: Implementar lógica de saque na origem e depósito no destino.
- [ ] **Validação:** O método transferir deve bloquear envio se `destino` for `ContaSalario` (usar `instanceof`).