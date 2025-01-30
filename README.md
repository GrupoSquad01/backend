# Acerta! - Backend

O **Acerta!** é uma aplicação web destinada ao estudo de vestibulares, concursos, etc, que utiliza gamificação e IA para ajudar os usuários a se prepararem de maneira eficaz.  O sistema permite que os usuários se registrem, acompanhem seu progresso em várias disciplinas e realizem simulados personalizados.

A principal proposta do AppAcerta é proporcionar aos usuários uma experiência de aprendizado dinâmica, com questões personalizadas pela IA, além de um sistema de XP (experiência) para incentivar o engajamento contínuo com os estudos.

Este repositório contém o código-fonte do **backend**, desenvolvido utilizando Java com o framework Spring Boot e utiliza o banco de dados PostgreSQL para gerenciar os dados dos usuários, disciplinas, progressos e muito mais.



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

## Configuração do Banco de Dados (PostgreSQL)

1. **Instalar o PostgreSQL** (se não tiver instalado):
   - Baixe o PostgreSQL no [site oficial](https://www.postgresql.org/download/).

2. **Criar o banco de dados**:
   - Após instalar o PostgreSQL, abra o terminal ou o pgAdmin e execute o seguinte comando para criar o banco de dados:

     ```sql
     CREATE DATABASE acerta;
     ```

3. **Configuração do banco no backend**:
   - No backend, altere o arquivo `src/main/resources/application.properties` para configurar a conexão com o PostgreSQL:

     ```properties
     spring.datasource.url=jdbc:postgresql://[HOSTNAME]:[PORT]/acerta
     spring.datasource.username=[USERNAME]
     spring.datasource.password=[PASSWORD]
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.show-sql=true
     ```

     - **[HOSTNAME]**: coldly-eventful-wolffish.data-1.tembo.io
     - **[PORT]**: A porta padrão do PostgreSQL é `5432`
     - **[USERNAME]**: postgres
     - **[PASSWORD]**: fxXxTMJXUnzuzTu1



---

### Modelo `Disciplina`

A classe `Disciplina` representa uma disciplina de estudo no sistema. Ela é mapeada para a tabela `disciplina` no banco de dados e contém as seguintes informações:

- **id**: Identificador único da disciplina.
- **nome**: Nome da disciplina (por exemplo, Matemática, Física, etc.).

Essa classe é utilizada para representar e gerenciar as disciplinas disponíveis para os usuários no sistema.

#### Relacionamento:
- **Nenhum relacionamento direto**. É uma entidade independente, mas pode se relacionar com outras entidades como `UsuarioDisciplina`.


### Modelo `UsuarioDisciplina`

A classe `UsuarioDisciplina` é responsável por representar a associação entre um usuário e uma disciplina específica. Ela é mapeada para a tabela `usuario_disciplina` e contém os seguintes atributos:

- **id**: Identificador único dessa associação.
- **usuario**: Relacionamento com a entidade `Usuarios`. Um usuário pode estar associado a várias disciplinas.
- **disciplina**: Relacionamento com a entidade `Disciplina`. Uma disciplina pode ter vários usuários associados.
- **respostasCertas**: Armazena o número de respostas corretas que o usuário obteve em determinada disciplina.

#### Relacionamentos:
- **@ManyToOne** entre `UsuarioDisciplina` e `Usuarios`: Cada `UsuarioDisciplina` está relacionado a um único usuário.
- **@ManyToOne** entre `UsuarioDisciplina` e `Disciplina`: Cada `UsuarioDisciplina` está associado a uma disciplina específica.
  

### Modelo `Usuarios`

A classe `Usuarios` representa os dados de um usuário do sistema. Ela está mapeada para a tabela `usuario` no banco de dados e contém as seguintes informações:

- **id**: Identificador único do usuário.
- **nome**: Nome completo do usuário.
- **username**: Nome de usuário único para login.
- **senha**: Senha do usuário (armazenada de forma segura).
- **email**: Endereço de email do usuário.
- **telefone, foto, dataNascimento, nacionalidade, raca, genero**: Informações adicionais sobre o usuário.
- **sequenciaDias**: Um contador para acompanhar o número de dias consecutivos em que o usuário completou atividades ou desafios.
- **dataUltimaResposta**: Timestamp que indica a última vez que o usuário respondeu a uma questão.

#### Relacionamentos:
- **@OneToMany** (indireto): O usuário pode ter várias associações com disciplinas, representadas na tabela `usuario_disciplina`.

## DisciplinaController

O `DisciplinaController` é responsável por gerenciar as operações CRUD (Criar, Ler, Atualizar e Deletar) para as disciplinas no sistema. Ele usa a classe `DisciplinaService` para manipulação dos dados da disciplina.

### Endpoints:

- **POST /disciplinas**:
  - **Descrição**: Cria uma nova disciplina.
  - **Parâmetros**: Um objeto `DisciplinaDto` no corpo da requisição, contendo o nome da disciplina.
  - **Resposta**: Retorna a disciplina criada com status HTTP `201 Created`.

- **GET /disciplinas**:
  - **Descrição**: Lista todas as disciplinas cadastradas.
  - **Resposta**: Retorna uma lista de `DisciplinaDto` com status HTTP `200 OK`.

- **PUT /disciplinas/{id}**:
  - **Descrição**: Atualiza uma disciplina existente com base no ID fornecido.
  - **Parâmetros**: O ID da disciplina na URL e um objeto `DisciplinaDto` no corpo da requisição com os novos dados.
  - **Resposta**: Retorna a disciplina atualizada com status HTTP `200 OK`.

- **DELETE /disciplinas/{id}**:
  - **Descrição**: Remove uma disciplina com base no ID fornecido.
  - **Parâmetros**: O ID da disciplina na URL.
  - **Resposta**: Retorna status HTTP `200 OK` indicando que a operação foi bem-sucedida.

- **GET /disciplinas/{id}**:
  - **Descrição**: Busca uma disciplina pelo ID fornecido.
  - **Parâmetros**: O ID da disciplina na URL.
  - **Resposta**: Retorna a disciplina correspondente com status HTTP `200 OK`.

## UsuarioDisciplinaController

O `UsuarioDisciplinaController` gerencia as operações CRUD para associar usuários a disciplinas, permitindo também manipular dados específicos dessa associação, como o número de respostas corretas em cada disciplina.

### Endpoints:

- **POST /usuarios-disciplinas**:
  - **Descrição**: Cria uma nova associação entre um usuário e uma disciplina.
  - **Parâmetros**: Um objeto `UsuarioDisciplinaDto` no corpo da requisição com os dados do usuário, disciplina e o número de respostas corretas.
  - **Resposta**: Retorna a associação criada com status HTTP `200 OK`.

- **GET /usuarios-disciplinas**:
  - **Descrição**: Lista todas as associações entre usuários e disciplinas.
  - **Resposta**: Retorna uma lista de `UsuarioDisciplinaDto` com status HTTP `200 OK`.

- **PUT /usuarios-disciplinas/{id}**:
  - **Descrição**: Atualiza uma associação existente entre usuário e disciplina.
  - **Parâmetros**: O ID da associação na URL e um objeto `UsuarioDisciplinaDto` com os novos dados.
  - **Resposta**: Retorna a associação atualizada com status HTTP `200 OK`.

- **DELETE /usuarios-disciplinas/{id}**:
  - **Descrição**: Remove uma associação entre um usuário e uma disciplina.
  - **Parâmetros**: O ID da associação na URL.
  - **Resposta**: Retorna status HTTP `200 OK`.

- **GET /usuarios-disciplinas/{id}**:
  - **Descrição**: Lista as disciplinas associadas a um usuário específico.
  - **Parâmetros**: O ID do usuário na URL.
  - **Resposta**: Retorna uma lista de `UsuarioDisciplinaDto` com as disciplinas associadas com status HTTP `200 OK`.
  - 

## UsuariosController

O `UsuariosController` gerencia as operações CRUD para os usuários do sistema, permitindo o cadastro, atualização, listagem e exclusão de usuários, além de buscar um usuário específico pelo ID.

### Endpoints:

- **POST /usuarios**:
  - **Descrição**: Cria um novo usuário.
  - **Parâmetros**: Um objeto `UsuariosDto` no corpo da requisição com os dados do usuário (nome, email, etc.).
  - **Resposta**: Retorna o usuário criado com status HTTP `201 Created`.

- **GET /usuarios**:
  - **Descrição**: Lista todos os usuários cadastrados.
  - **Resposta**: Retorna uma lista de `UsuariosDto` com status HTTP `200 OK`.

- **PUT /usuarios/{id}**:
  - **Descrição**: Atualiza os dados de um usuário existente.
  - **Parâmetros**: O ID do usuário na URL e um objeto `UsuariosDto` com os novos dados do usuário.
  - **Resposta**: Retorna o usuário atualizado com status HTTP `200 OK`.

- **DELETE /usuarios/{id}**:
  - **Descrição**: Remove um usuário com base no ID fornecido.
  - **Parâmetros**: O ID do usuário na URL.
  - **Resposta**: Retorna status HTTP `200 OK`.

- **GET /usuarios/{id}**:
  - **Descrição**: Busca um usuário pelo ID fornecido.
  - **Parâmetros**: O ID do usuário na URL.
  - **Resposta**: Retorna o usuário correspondente com status HTTP `200 OK`.


  
## Contribuição  
Se você deseja contribuir com o projeto, sinta-se à vontade para abrir uma pull request. Certifique-se de que suas alterações não quebrem funcionalidades existentes e que o código esteja bem testado.

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.



