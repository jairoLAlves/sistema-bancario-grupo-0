# 🏦 Sistema Bancário - Projeto POO

Bem-vindo ao repositório oficial do projeto.

## 📚 Documentação (Manuais)

Antes de começar, leia o guia referente ao seu papel:

* 👑 **[SOU LÍDER: Clique aqui para configurar o projeto](doc/guia-lider.md)**
  *(Leia isto para saber como criar o Quadro Kanban e aceitar Pull Requests)*

* 🛠️ **[SOU DESENVOLVEDOR: Clique aqui para ver como programar](doc/guia-desenvolvedor.md)**
  *(Leia isto para aprender a criar Branches e não quebrar o código)*

---
## 👥 Integrantes do Grupo
* **Líder:** [Jairo L. Alves](https://github.com/jairoLAlves)
* **Membro 2:** [Th4mz0](https://github.com/TH4MZ0)


## 📋 Backlog do Projeto (Status)

O Líder deve marcar as caixas abaixo conforme o grupo avança (`[x]`):

### Fase 1: Configuração
- [x] Setup Inicial (Projeto Clonado e Commitado)
- [x] Estrutura de Pastas (`br.com.banco`) definida

### Fase 2: Implementação (Java)

#### Uso de Herança e classe abstrata:

- [x]  Crie uma classe base abstrata (ex.: Conta) que contenha os atributos e métodos comuns a todas as contas.

- [x]  A classe base abstrata permite garantir que as subclasses sobrescrevam os métodos **obrigatórios** (ex.: sacar, depositar, exibir Saldo e transferir).

- [x]  Cada tipo de conta (Corrente, Poupança e Salário) deverá ser uma subclasse que especializa a classe base e implementa os seus métodos abstratos de acordo com as suas particularidades.

#### Modificadores de Acesso:

- [x]  Utilize modificadores de acesso (private, protected e public) para encapsular os atributos e métodos de forma adequada.

- [x]  Garanta que atributos sensíveis (ex.: saldo) não sejam modificados diretamente.

#### Testes e Demonstração:

- [x]  Crie uma classe principal, contendo o método main que demonstre o funcionamento do sistema bancário.

**Simule operações como:**

- [x]   Criação de contas.

- [x]  Realização de saques, depósitos e transferências.

- [x]  Aplicação do rendimento na conta poupança.

- [x]  Tentativa de transferir valores para uma conta salário (operação não permitida).

 ### Tratamento de Exceções:

- [x] Implemente mecanismos para capturar e tratar exceções, garantindo que o sistema não quebre em situações inesperadas.
***Exemplo:*** Capturar tentativas de saque com valor inválido ou saldo insuficiente, impedir transferências para contas inexistentes ou contas salário, entre outros cenários comuns.

### Estrutura de Dados para Extrato Bancário:

- [x] Utilize uma estrutura de dados apropriada (como listas, filas ou coleções) para armazenar e exibir um histórico de transações.


- [x] O extrato deve registrar operações como saques, depósitos e transferências e exibi-las sempre que for solicitado.

### Criação de Interface Gráfica:

- [x] Desenvolva uma interface gráfica para o sistema, tornando a interação com o usuário mais intuitiva. A interface deve permitir operações como criação de contas, saques, depósitos, transferências e exibição do extrato bancário.

### Fase 3: Entrega
- [x] Testes na `Main.java` realizados
- [x] Vídeo demonstrativo gravado
- [x] Link do vídeo adicionado abaixo

---
**🎥 Link do Vídeo:** (https://www.youtube.com/watch?v=Iy-bqElsqpc)
**🎥 Link do Vídeo 2 :** (https://www.youtube.com/watch?v=yLWhtdnnUCs)
