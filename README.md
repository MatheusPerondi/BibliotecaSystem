# Projeto de Gerenciamento de Biblioteca

Este é um sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando Hibernate para persistência de dados e MySQL como banco de dados. O projeto visa gerenciar livros, autores, categorias, editoras, clientes e empréstimos de forma eficiente.

## Funcionalidades

- **Gerenciamento de Livros:** Cadastro, atualização e consulta de livros, incluindo detalhes como nome, ano de publicação, categoria, editora, quantidade em estoque e exemplares disponíveis.
- **Gerenciamento de Autores:** Cadastro e consulta de autores, com informações como nome, data de nascimento e nacionalidade.
- **Gerenciamento de Categorias e Editoras:** Cadastro e consulta de categorias e editoras.
- **Gerenciamento de Clientes:** Cadastro e consulta de clientes, com informações de contato.
- **Empréstimos e Devoluções:** Registro de empréstimos e devoluções de livros, com controle de exemplares disponíveis.

## Tecnologias Utilizadas

- **Java:** Linguagem de programação principal do projeto.
- **Hibernate:** Framework ORM para mapeamento objeto-relacional.
- **MySQL:** Sistema de gerenciamento de banco de dados relacional.
- **JPA (Java Persistence API):** API para manipulação de dados persistentes.

## Estrutura do Projeto

- **Entity:** Contém as classes de entidade que representam as tabelas do banco de dados.
- **DAO (Data Access Object):** Classes responsáveis pelas operações de acesso e manipulação dos dados.
- **Service:** Classe principal para execução de operações e testes do sistema.
- **Util:** Classes utilitárias, como a carga inicial de dados e configuração do JPA.

## Configuração

1. **Crie um banco de dados MySQL para o projeto.**
2. **Atualize as configurações de conexão no arquivo `persistence.xml` (se aplicável).**

## Compilação e Execução

1. **Compile o projeto utilizando o Maven ou Gradle.**
2. **Execute a classe `Service` para iniciar o sistema e testar as funcionalidades.**

## Uso

- **Cadastro e Consulta de Livros:** Adicione e visualize livros com detalhes completos, incluindo disponibilidade.
- **Cadastro e Consulta de Autores:** Gerencie informações dos autores.
- **Cadastro e Consulta de Categorias e Editoras:** Adicione e consulte categorias e editoras.
- **Cadastro e Consulta de Clientes:** Gerencie informações dos clientes.
- **Empréstimos e Devoluções:** Registre e controle o status dos empréstimos e devoluções de livros.

## Contribuição

Se você deseja contribuir para este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Suas contribuições são bem-vindas!
