# 👑 Guia do Líder do Grupo

Seu papel é preparar o repositório e convidar a equipe.
**Você é o "Dono" do projeto.** Todos trabalharão no SEU repositório.

## Configuração Inicial (Faça isso agora)
## 1. Criando o Repositório do Grupo

**NÃO faça Clone nem Fork deste projeto.** Vamos usar a função de Modelo para criar uma cópia limpa para vocês.

1.  Olhe para o topo desta página (no GitHub).
2.  Clique no botão verde escrito **"Use this template"** > **"Create a new repository"**.
3.  **Configurações:**
    * **Repository name:** Dê um nome para o projeto do seu grupo (ex: `sistema-bancario-grupo-3`).
    * **Privacy:** Deixe como Public.
    * **Include all branches:** Pode deixar desmarcado.
4.  Clique em **Create repository**.

🎉 **Pronto!** Agora você tem um repositório novo, zerado, mas com todos os arquivos e pastas do modelo já dentro dele.

---

## 2. Trazendo para seu Computador

Agora que o repositório do SEU GRUPO existe:

1.  Copie o link do **SEU** repositório novo (que você acabou de criar).
2.  Abra sua IDE ou Terminal.
3.  Clone o **SEU** repositório:
    ```bash
    git clone <COLE_O_LINK_DO_SEU_NOVO_REPOSITORIO_AQUI>
    ```
4.  Agora siga os passos para adicionar os membros em *Settings > Collaborators*.


## 3. Primeiros Passos (Setup)
1.  **Convide a Equipe:** Vá em `Settings > Collaborators` e adicione os e-mails dos colegas.
2.  **Crie as Tarefas:** Vá na aba **Issues**, clique em "New Issue" e selecione os templates prontos (Conta, Conta Corrente, etc.) para criar o backlog oficial.
3.  **Crie o Kanban:**
    * Vá na aba **Projects** > **New Project**.
    * Escolha "Board".
    * Crie colunas: `A Fazer`, `Fazendo`, `Feito`.

## 4. Protegendo o Código
Para evitar que alguém apague tudo por erro:
1.  Vá em `Settings > Branches`.
2.  Em "Branch protection rules", clique em **Add rule**.
3.  Branch name pattern: `main`.
4.  Marque: "Require a pull request before merging".

## 5. Revisando Pull Requests (PR)
Quando um membro terminar uma tarefa:
1.  Vá na aba **Pull Requests**.
2.  Clique no PR aberto.
3.  Vá em "Files changed" para ver o código dele.
4.  Se estiver bom, clique em **Merge pull request**.
5.  Se tiver erro, comente na linha do código pedindo correção.