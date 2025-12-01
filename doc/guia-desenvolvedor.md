# 🛠️ Guia do Desenvolvedor

Siga estas regras estritamente para ganhar nota máxima em organização.

## ⛔ Regra de Ouro
**NUNCA** faça commit direto na branch `main`.
Sempre crie uma branch para sua tarefa.

## 🔄 Fluxo de Trabalho (Passo a Passo)

### 1. Escolha uma Tarefa
Vá na aba **Issues** ou **Projects** e veja o que precisa ser feito.
*Exemplo: Vou fazer a "Implementar Conta Poupança" (Issue #4).*

### 2. Atualize seu Projeto Local
Antes de codar, garanta que você tem a versão mais nova do projeto:
```bash
    git checkout main
    git pull origin main
```
### 3. Crie sua Branch
Crie uma "sala separada" para trabalhar. Use o número da Issue no nome:
```bash
    git checkout -b feature-conta-poupanca
```
### 4. Programe e Envie
Faça seu código Java. Quando terminar:
Em (Closes #Numero_Da_Issue_Atual)
```bash
    git add .
    git commit -m "Implementa Conta Poupança (Closes #4)"
    git push origin feature-conta-poupanca
```
