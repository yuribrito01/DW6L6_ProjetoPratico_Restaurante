# DW6L6 - Projeto Pratico
Projeto 01: Trabalho Prático de Desenvolvimento Web com Java, JDBC e MySQL

> Data de entrega: 22/05/2025

Desenvolvido por Pamela Dantas e Yuri Brito durante a disciplina de DESENVOLVIMENTO DE SISTEMAS WEB (DSWL6), ministrada pelo Professor Dr. Carlos Eduardo Beluzo no Curso Análise e Desenvolvimento de Sistemas, IFSP Campinas.

## Sistema de Reservas para Restaurante:
Sistema de reservas que permite aos clientes fazerem reservas de mesas em um restaurante, visualizando a disponibilidade de horários e confirmando reservas.

### Tecnologias Utilizadas

- Java 11+
- Jakarta Servlet API
- JSP (Java Server Pages)
- JDBC (Java Database Connectivity)
- MySQL
- Apache Tomcat 11.x
- Eclipse IDE
- MySQL Connector/J

### Estrutura do Projeto

```
DW6L6_ProjetoPratico_Restaurante/
└───src
    └───main
        ├───java
        │   └───br.com.reservas
        │                ├───dao
        │                │   ├── ClienteDao.java
        │                │   ├── MesaDao.java
        │                │   └── ReservaDao.java
        │                │
        │                ├───model
        │                │   ├── Cliente.java
        │                │   ├── Mesa.java
        │                │   └── Reserva.java
        │                │
        │                ├───servlet
        │                │   ├── ClienteServlet.java
        │                │   ├── MesaServlet.java
        │                │   └── ReservaServlet.java
        │                │
        │                └───util
        │                    └── ConexaoUtil.java
        │
        └───webapp
            ├── cliente.jsp
            ├── mesa.jsp
            ├── reserva.jsp
            │
            ├── META-INF
            │   └── MANIFEST.MF
            │
            └── WEB-INF
                ├── web.xml
                └── lib
                    └── mysql-connector-j-9.3.0.jar
```

### Funcionalidades Detalhadas

#### > Gerenciamento de Clientes

- **Cadastro de Cliente**: O `ClienteServlet` permite cadastrar novos clientes via formulário na página `cliente.jsp`. Os dados são armazenados no banco de dados por meio da classe `ClienteDao`.
- **Listagem de Clientes**: Pode ser implementada com uma página adicional que utiliza `ClienteDao` para buscar todos os registros.
- **Edição de Cliente**: Implementável reutilizando o mesmo formulário de cadastro, com dados previamente preenchidos.
- **Exclusão de Cliente**: Pode ser implementada com ação no servlet usando o ID do cliente.

#### > Gerenciamento de Mesas

- **Cadastro de Mesa**: O `MesaServlet` cadastra novas mesas através do formulário em `mesa.jsp`, usando `MesaDao` para inserção no banco.
- **Listagem de Mesas**: Pode ser feita exibindo todas as mesas usando `MesaDao`.
- **Edição e Exclusão de Mesa**: Também implementáveis por meio de servlets e o DAO correspondente.

#### > Gerenciamento de Reservas

- **Cadastro de Reserva**: Realizado por `ReservaServlet` a partir do formulário em `reserva.jsp`, armazenando os dados via `ReservaDao`.
- **Listagem de Reservas**: Pode ser feita com `ReservaDao` retornando todas as reservas.
- **Edição e Exclusão de Reserva**: Possível utilizando os métodos de `ReservaDao` e `ReservaServlet`.

### Banco de Dados

Crie o banco com o script abaixo no MySQL:

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
    tipo VARCHAR(50)
);

-- Tabela mesa
CREATE TABLE mesa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    capacidade INT NOT NULL
);

-- Tabela reserva
CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    mesa_id INT NOT NULL,
    data_hora DATETIME NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (mesa_id) REFERENCES mesa(id)
);


```

### Configuração

- Banco de dados: MySQL
- Nome do banco: `reservas_db`
- Usuário padrão: `root`
- Senha padrão do seu MySQL (ajustável em `ConexaoUtil.java`)
- Tomcat: versão 11 (compatível com Jakarta EE 10)
- IDE sugerida: Eclipse

### Observações

- Certifique-se de ter o conector MySQL (`mysql-connector-j-9.3.0.jar`) em `WEB-INF/lib`.
- Configure corretamente o nome do projeto no `web.xml` ou na URL do navegador (ex: `http://localhost:8080/DW6L6_ProjetoPratico_Restaurante/cliente`).
- Verifique se a aplicação está sendo de fato implantada no Tomcat.

### Dificuldades encontradas

A maior dificuldade encontrada (que não é tão séria e nem impactou tanto) por ambos foi, com certeza, a preparação do ambiente do projeto no Eclipse. Baixar e acostumar a usar Tomcat, baixando .jar, entender o Servlet, checar o output no Java Build Path, entre outras coisas do tipo. Mas, depois de tudo configurado, não tivemos mais problemas!
Além disso, a linguagem Java ainda é um pequeno desafio para nós dois, por falta de costume com o uso dela. O projeto em si não apresentou um desafio muito grande para ser desenvoldido pois a proposta era simples!

### Autores

- Yuri Brito — [@yuribrito01](https://github.com/yuribrito01)
- Pamela Dantas — [@pameladantasp](https://github.com/pameladantasp)


