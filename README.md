# Sistema de Gerenciamento de Alunos - Ciclus

Aplicação web desenvolvida em **Spring Boot** para gerenciamento de alunos, com autenticação simples e banco de dados em memória.

## Funcionalidades
- **CRUD completo** para 2 entidades.
- Relacionamento **ManyToOne** entre **Aluno** e **Monitor**, através da chave estrangeira `monitor_id` na tabela `alunos`.
- Swagger UI integrado para a realização de testes dos endpoints.
- Banco de dados **H2** integrado para fácil execução e testes.

## Autenticação
- Credenciais armazenadas **em memória**.
- Usuário padrão = username: admin
  password: 123 

## Tecnologias Utilizadas
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **H2 Database**

## Acesso ao Swagger

- Console disponível em: http://localhost:8080/swagger-ui/index.html

## Acesso ao Banco de Dados
- Console do H2 disponível em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:~/teste`
- Usuário: *(vazio)*
- Senha: *(vazio)*

