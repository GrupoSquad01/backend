# Endpoints de Usuários

Este controlador (`UsuariosController`) expõe uma série de endpoints para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) no recurso "usuário". As operações são realizadas por meio do serviço `UsuariosService`. A seguir estão os detalhes de cada endpoint:

## 1. **Cadastrar Usuário**
   - **Método HTTP:** `POST`
   - **Endpoint:** `/usuarios`
   - **Descrição:** Cria um novo usuário.
   - **Corpo da Requisição (JSON):**
     ```json
     {
       "nome": "Nome do Usuário",
       "username": "username_do_usuario",
       "email": "email@dominio.com",
       "senha": "senha123"
     }
     ```
   - **Resposta:** Retorna o usuário criado com status HTTP 201 (Criado).

---

## 2. **Listar Todos os Usuários**
   - **Método HTTP:** `GET`
   - **Endpoint:** `/usuarios`
   - **Descrição:** Retorna a lista de todos os usuários cadastrados no sistema.
   - **Resposta:** Lista de usuários com status HTTP 200 (OK).

---

## 3. **Buscar Usuário por ID**
   - **Método HTTP:** `GET`
   - **Endpoint:** `/usuarios/{id}`
   - **Descrição:** Retorna as informações de um usuário específico, identificado pelo seu ID.
   - **Parâmetro:** `id` (Identificador do usuário)
   - **Resposta:** Detalhes do usuário com status HTTP 200 (OK).

---

## 4. **Atualizar Usuário**
   - **Método HTTP:** `PUT`
   - **Endpoint:** `/usuarios/{id}`
   - **Descrição:** Atualiza os dados de um usuário existente.
   - **Parâmetro:** `id` (Identificador do usuário)
   - **Corpo da Requisição (JSON):**
     ```json
     {
       "nome": "Novo Nome",
       "username": "novo_username",
       "email": "novo_email@dominio.com",
       "senha": "nova_senha123"
     }
     ```
   - **Resposta:** Usuário atualizado com status HTTP 200 (OK).

---

## 5. **Remover Usuário**
   - **Método HTTP:** `DELETE`
   - **Endpoint:** `/usuarios/{id}`
   - **Descrição:** Exclui um usuário do sistema.
   - **Parâmetro:** `id` (Identificador do usuário)
   - **Resposta:** Status HTTP 200 (OK) indicando que o usuário foi excluído com sucesso.

---
