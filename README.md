<img src="https://img.shields.io/badge/STATUS-CONCLUÍDO-green"/>

# DW6L6 - Projeto Pratico
Projeto 01: Trabalho Prático de Desenvolvimento Web com Java.

Desenvolvido por Pamela Dantas e Yuri Brito durante a disciplina de DESENVOLVIMENTO DE SISTEMAS WEB (DSWL6), ministrada pelo Professor Dr. Carlos Eduardo Beluzo no Curso Análise e Desenvolvimento de Sistemas, IFSP Campinas.

## Projeto CRUD Spring Boot

## Sobre o Projeto:
Sistema de Reservas para Restaurante:
Sistema que permite aos usuários (nesse caso, simulando funcionários) fazerem reservas de mesas em um restaurante, visualizando a disponibilidade de horários e confirmando reservas.
Uma aplicação web modelada no padrão MVC em Java e construída com o Spring Boot, o projeto conta com uma estrutura de CRUD, no qual os dados estão sendo persistidos em um banco de dados (MySQL). Na camada de visualização foi utilizado HTML, CSS, o framework Bootstrap e o template Thymeleaf.  Também foi utilizado o JavaScript para validação de uma regra de negócio. O sistema possui outras funcionalidades como, tela de login/cadastro, criptografia de dados do usuário, entre outras.

 
## Tecnologias Utilizadas

> Java

> Spring Boot

> JPA / Hibernate

> Maven

> HTML/CSS/JS

> Bootstrap

> MySQL


## Demonstração

![sistemarestaurante](https://github.com/user-attachments/assets/15d92efb-287d-430a-a8f6-23817da5d154)


## Banco de Dados
```sql
-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS reservas_db;
USE reservas_db;

-- Tabela cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20),
    tipocliente VARCHAR(50)
);

-- Tabela mesa
CREATE TABLE mesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    capacidade INT NOT NULL
);

-- Tabela reserva
CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEYmesacliente,
    cliente_id INT NOT NULL,
    mesa_id INT NOT NULL,
    data_hora DATETIME NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (mesa_id) REFERENCES mesa(id)
);
```


## Configurações do banco de dados
Crie um banco de dados MySQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. Para isso abra o arquivo application.properties, localizado em src/main/resources/application.properties e altere os seguintes comandos ao arquivo:

```
- spring.datasource.url = jdbc:mysql://localhost:3306/nome-do-seu-banco-de-dados?useTimezone=true&serverTimezone=UTC
- spring.datasource.username = root
- spring.datasource.password = root
```


## Instalação e Execução
Gerenciado pelo Maven.
- Baixe ou clone o projeto em uma IDE (usamos VS Code).
- Abra o arquivo "GerenciamentoRestauranteApplication.java" (em src\main\java\br\com\gerenciamento) e clique para executar
![image](https://github.com/user-attachments/assets/1ff82b53-82eb-4d65-af78-e6cb6bdc4818)
- Ou, abra o cmd da IDE no mesmo path do arquivo pom.xml e execute: mvn spring-boot:run
- Após a execução, abra um navegador e digite: http://localhost:8080
