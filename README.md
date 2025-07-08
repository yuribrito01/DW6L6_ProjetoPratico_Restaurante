<img src="https://img.shields.io/badge/STATUS-CONCLUÍDO-green"/>

# API RESTful para Gerenciamento de Restaurante

Trabalho Prático da disciplina de DESENVOLVIMENTO DE SISTEMAS WEB (DSWL6), ministrada pelo Professor Dr. Carlos Eduardo Beluzo no Curso de Análise e Desenvolvimento de Sistemas do IFSP Campinas.

**Desenvolvido por:**
* Pamela Dantas
* Yuri Brito

---

## 1. Sobre o Projeto

Esta aplicação é uma **API RESTful** para o gerenciamento de um restaurante, permitindo o controle de clientes, mesas e reservas. O sistema possui um mecanismo de autenticação seguro baseado em **JSON Web Tokens (JWT)**, com diferentes níveis de acesso (perfis) para os usuários.

### Evolução do Projeto
Este projeto representa a segunda fase e a evolução de uma aplicação web monolítica que foi inicialmente construída com Spring MVC e Thymeleaf, dando continuidade a um trabalho desenvolvido com Servlets e Hibernate. A arquitetura foi refatorada para uma API RESTful, desacoplando o backend do frontend e implementando um sistema de segurança stateless alinhado com as práticas modernas de mercado.

---

## 2. Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot, Spring Security, Spring Data JPA
* **Banco de Dados:** MySQL
* **Autenticação:** JSON Web Tokens (JWT)
* **Build & Dependências:** Maven
* **Testes da API:** Postman

---

## 3. Demonstração da Aplicação (Versão Antiga - MVC/)

O GIF abaixo demonstra a interface gráfica da primeira versão do projeto. A versão atual, uma API RESTful, não possui interface gráfica e é interagida através de endpoints JSON, como documentado no "Guia da API".

![sistemarestaurante](https://github.com/user-attachments/assets/15d92efb-287d-430a-a8f6-23817da5d154)

---

## 4. Configuração do Ambiente e Execução

Siga os passos abaixo para clonar, configurar e executar o projeto localmente.

### 4.1. Pré-requisitos
* Java 17 ou superior.
* Apache Maven 3.6 ou superior.
* MySQL 8.0 ou superior.
* Uma ferramenta de API, como o [Postman](https://www.postman.com/downloads/).

### 4.2. Passos para Execução
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/yuribrito01/DW6L6_ProjetoPratico_Restaurante.git](https://github.com/yuribrito01/DW6L6_ProjetoPratico_Restaurante.git)
    cd DW6L6_ProjetoPratico_Restaurante
    ```

2.  **Crie o Banco de Dados:**
    Execute o seguinte comando no seu cliente MySQL para criar o banco de dados necessário:
    ```sql
    CREATE DATABASE IF NOT EXISTS reservas_db;
    ```

3.  **Configure a Conexão:**
    Abra o arquivo `src/main/resources/application.properties` e verifique se as credenciais do seu banco de dados local estão corretas:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/reservas_db?useTimezone=true&serverTimezone=UTC
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    ```
    *O Hibernate irá criar as tabelas automaticamente na primeira vez que a aplicação for executada (`ddl-auto=update`).*

4.  **Execute a Aplicação:**
    Use o Maven para iniciar o servidor Spring Boot:
    ```bash
    mvn spring-boot:run
    ```
    A API estará rodando em `http://localhost:8080`.

---

## 5. Guia da API (Endpoints)

Use o Postman ou similar para interagir com os endpoints abaixo.

### 5.1. Autenticação

#### **Registrar um Novo Usuário**
* **Verbo:** `POST`
* **URL:** `/api/auth/register`
* **Descrição:** Cria um novo usuário. A `role` pode ser "ROLE_USER" ou "ROLE_ADMIN".
* **Corpo da Requisição (JSON):**
    ```json
    {
        "email": "admin@restaurante.com",
        "user": "admin",
        "senha": "password123",
        "role": "ROLE_ADMIN"
    }
    ```
* **Resposta de Sucesso:** `200 OK`

#### **Fazer Login e Obter Token**
* **Verbo:** `POST`
* **URL:** `/api/auth/login`
* **Descrição:** Autentica um usuário e retorna um token JWT.
* **Corpo da Requisição (JSON):**
    ```json
    {
        "email": "admin@restaurante.com",
        "senha": "password123"
    }
    ```
* **Resposta de Sucesso (JSON):**
    ```json
    {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkByZXN0YXVyYW50ZS5jb20iLCJpYXQiOjE3..."
    }
    ```

### 5.2. Clientes

*Para acessar os endpoints de clientes, é necessário enviar o token JWT no cabeçalho `Authorization` como `Bearer <seu_token>`.*

#### **Listar Todos os Clientes**
* **Verbo:** `GET`
* **URL:** `/api/clientes`
* **Resposta de Sucesso (JSON):**
    ```json
    [
        {
            "id": 1,
            "nome": "Cliente VIP Teste",
            "email": "vip@cliente.com",
            "telefone": "19912345678",
            "funcao": "Membro Ouro"
        }
    ]
    ```

#### **Criar um Novo Cliente**
* **Verbo:** `POST`
* **URL:** `/api/clientes`
* **Autorização:** Requer perfil `ROLE_ADMIN`.
* **Corpo da Requisição (JSON):**
    ```json
    {
        "nome": "Novo Cliente",
        "email": "novo@cliente.com",
        "telefone": "19123456789",
        "funcao": "Regular"
    }
    ```
* **Resposta de Sucesso:** `201 Created` com o objeto do cliente criado.

#### **Deletar um Cliente**
* **Verbo:** `DELETE`
* **URL:** `/api/clientes/{id}`
* **Autorização:** Requer perfil `ROLE_ADMIN`.
* **Resposta de Sucesso:** `204 No Content`

*(Documente os outros endpoints de Mesa e Reserva aqui seguindo o mesmo modelo)*

---

## 6. Estrutura do Projeto

A aplicação segue uma arquitetura em camadas para promover baixo acoplamento e alta coesão:
* **`config`**: Configurações de segurança do Spring Security e JWT.
* **`controller`**: Camada de apresentação, expõe os endpoints `@RestController`.
* **`dtos`**: Data Transfer Objects para carregar dados entre o cliente e a API.
* **`exception`**: Classes de exceções customizadas.
* **`model`**: Entidades JPA que mapeiam as tabelas do banco de dados.
* **`repository`**: Interfaces Spring Data JPA para acesso aos dados.
* **`service`**: Camada que contém as regras de negócio da aplicação.

---

## 7. Autores

* Pamela Dantas
* Yuri Brito
