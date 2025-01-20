# Acerta!

O **Acerta!** é uma aplicação web destinada ao estudo de vestibulares, concursos, etc, que utiliza gamificação e IA para ajudar os usuários a se prepararem de maneira eficaz. O sistema permite que os usuários se registrem, acompanhem seu progresso em várias disciplinas e realizem simulados personalizados.

## Estrutura do Projeto

- **Backend**: Desenvolvido com Java, utilizando o Spring Boot.
- **Frontend**: Desenvolvido com React.
- **Banco de Dados**: PostgreSQL.

## Pré-requisitos

Antes de rodar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17 ou superior** (para o backend)
- **Maven** (para construir e rodar o backend)
- **Node.js e npm** (para o frontend)
- **PostgreSQL** (para o banco de dados)

## Configuração do Banco de Dados (PostgreSQL)

1. **Instalar o PostgreSQL** (se não tiver instalado):
   - Baixe o PostgreSQL no [site oficial](https://www.postgresql.org/download/).

2. **Criar um banco de dados**:
   - Após instalar o PostgreSQL, abra o terminal ou o pgAdmin e execute o seguinte comando para criar o banco de dados:
     
       ` 
  Sql
   CREATE DATABASE acerta;
   `
   
## Configuração do banco no backend:  
- No backend, altere o arquivo src/main/resources/application.properties para configurar a conexão com o PostgreSQL:

- spring.datasource.url=jdbc:postgresql://localhost:5432/appacerta
- spring.datasource.username=postgres
- spring.datasource.password=your_password
- spring.datasource.driver-class-name=org.postgresql.Driver
- spring.jpa.hibernate.ddl-auto=update
- spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
- spring.jpa.show-sql=true

## Estrutura de Pastas
 - O projeto segue a seguinte estrutura de pastas:

acerta/  
├── backend/  
│   ├── src/       
│   ├── pom.xml                 
│   ├── src/main/resources/application.properties    
├── frontend/                  
│   ├── public/  
│   ├── src/                   
│   ├── package.json         


### Explicação da Estrutura:

- **acerta/**: Raiz do projeto, onde o backend e o frontend estão localizados.
- **backend/**: Contém o código do backend, desenvolvido em Java com Spring Boot.
- **src/**: Contém o código-fonte em Java.
- **pom.xml**: Arquivo que gerencia as dependências do Maven.
- **src/main/resources/application.properties**: Arquivo de configuração do Spring Boot.
- **frontend/**: Contém o código do frontend, desenvolvido em React.
- **public/**: Contém arquivos públicos como HTML, imagens, etc.
- **src/**: Contém o código-fonte em React.
- **package.json**: Arquivo que gerencia as dependências do Node.js.

## Passos para Executar o Projeto

 - Siga os passos abaixo para executar o projeto localmente:

1. **Clonar os Repositórios**
 - Clone os repositórios do backend e do frontend para a sua máquina local.

**Backend:**

` 
bash
git clone https://github.com/GrupoSquad01/backend.git
`  

**Frontend:**  
` 
bash
git clone https://github.com/GrupoSquad01/frontend.git
`   


2. **Configuração e Execução do Backend**
   - Navegue até o diretório backend:
     
`bash
cd backend
`  
   - Execute o comando para rodar o Spring Boot:
     
`
bash
./mvnw spring-boot:run
`
   - O backend estará disponível em http://localhost:8080.

3. **Configuração e Execução do Frontend**
   
1. **Navegue até o diretório frontend:**
`
bash
cd frontend
`
2. **Instale as dependências do frontend:**

` bash
npm install` 

3. **Execute o frontend:**

` bash
npm start ` 

 - O frontend estará disponível em http://localhost:3000.

## Endpoints de Usuários

O controlador expõe uma série de endpoints para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) no recurso "usuário". As operações são realizadas por meio do serviço `UsuariosService`. A seguir estão os detalhes de cada endpoint:

1. **Cadastrar Usuário**
   - **Método HTTP:** `POST`
   - **Endpoint:** `/usuarios`
   - **Descrição:** Cria um novo usuário
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

2. **Listar Todos os Usuários**
   - **Método HTTP:** `GET`
   - **Endpoint:** `/usuarios`
   - **Descrição:** Retorna a lista de todos os usuários cadastrados no sistema.
   - **Resposta:** Lista de usuários com status HTTP 200 (OK).

---

3. **Buscar Usuário por ID**
   - **Método HTTP:** `GET`
   - **Endpoint:** `/usuarios/{id}`
   - **Descrição:** Retorna as informações de um usuário específico, identificado pelo seu ID.
   - **Parâmetro:** `id` (Identificador do usuário)
   - **Resposta:** Detalhes do usuário com status HTTP 200 (OK).

---

4. **Atualizar Usuário**
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

5. **Remover Usuário**
   - **Método HTTP:** `DELETE`
   - **Endpoint:** `/usuarios/{id}`
   - **Descrição:** Exclui um usuário do sistema.
   - **Parâmetro:** `id` (Identificador do usuário)
   - **Resposta:** Status HTTP 200 (OK) indicando que o usuário foi excluído com sucesso.

---
## Endpoints de Disciplina
**Disciplina:**  
 - A entidade Disciplina representa as matérias de estudo que os usuários podem escolher no sistema.

**Atributos:**  
-  id: Identificador único da disciplina (gerado automaticamente).
-  nome: Nome da disciplina (ex: Matemática, Física, Química).  

**Funcionalidades:**  
1. **Criar disciplina**
   - Método: POST /disciplinas
   - Corpo: { "nome": "Nome da Disciplina" }
  
2. **Listar todas as disciplinas**
   - Método: GET /disciplina
  
3. **Atualizar disciplina**
   - Método: PUT /disciplinas/{id}
   - Corpo: { "nome": "Novo Nome da Disciplina" }
  
4. **Excluir disciplina**
   - Método: DELETE /disciplinas/{id}
   
5. **Buscar disciplina por ID**
   - Método: GET /disciplinas/{id}
       
## Endpoints de DisciplinaUsuario  

**DisciplinaUsuario**
- A entidade DisciplinaUsuario representa o vínculo entre um usuário e uma disciplina, permitindo registrar o progresso de cada usuário em cada disciplina.
  
**Atributos:**  
- id: Identificador único do relacionamento (gerado automaticamente).
- usuario: Relacionamento com o usuário associado.
- disciplina: Relacionamento com a disciplina associada.
- progresso: Progresso do usuário na disciplina, representado por um valor numérico.

**Funcionalidades:**  
1. Associar usuário a uma disciplina
   - Método: POST /disciplinas-usuarios
   - Corpo: { "usuarioId": 1, "disciplinaId": 2, "progresso": 20 }
     
2. Listar todas as associaçõe
   - Método: GET /disciplinas-usuarios
          
3. Atualizar o progresso de um usuário em uma disciplina
   - Método: PUT /disciplinas-usuarios/{id}
   - Corpo: { "progresso": 50 }
  
           
4. Excluir associação
   - Método: DELETE /disciplinas-usuarios/{id}
      
5. Buscar associação por ID
   - Método: GET /disciplinas-usuarios/{id}
  
## Contribuição  
Se você deseja contribuir com o projeto, sinta-se à vontade para abrir uma pull request. Certifique-se de que suas alterações não quebrem funcionalidades existentes e que o código esteja bem testado.

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.



