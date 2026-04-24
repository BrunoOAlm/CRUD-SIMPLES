🚀 CRUD Básico - Sistema de Autenticação (Java + Spring Boot)

Projeto backend desenvolvido em Java com Spring Boot, focado em práticas de arquitetura em camadas e implementação de um fluxo de autenticação (login e registro) utilizando PostgreSQL e Spring Data JPA.

📌 Tecnologias utilizadas
Java 17
Spring Boot
Spring Data JPA
PostgreSQL
Lombok
Gradle
Git / GitHub
📌 Objetivo do projeto

Este projeto tem como objetivo praticar e demonstrar:

Estruturação de API REST
Separação em camadas (Controller, Service, Repository, Entity)
Uso de DTOs (Request/Response)
Autenticação básica (login e registro)
Integração com banco de dados PostgreSQL
Boas práticas de organização de código
📌 Funcionalidades
🔐 Autenticação
Registro de usuário
Login de usuário
Validação de credenciais
Persistência no banco PostgreSQL
📌 Arquitetura

Controller → Service → Repository → Database

📌 Estrutura do projeto
business/
└── AuthService
└── dtos/
    ├── in
    │   ├── LoginRequest
    │   └── RegisterRequest
    └── out
        └── LoginResponse

infrastructure/
├── entity
│   └── Usuario
└── repository
    └── UsuarioRepository
📌 Como executar o projeto
1. Clonar o repositório
git clone https://github.com/seu-usuario/seu-repo.git
2. Configurar o PostgreSQL

Criar banco:

crud_db

Configurar no application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/crud_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Rodar o projeto
./gradlew bootRun
📌 Endpoints (futuro Controller)
POST /auth/register
POST /auth/login
📌 Aprendizados
Organização de projeto em camadas
Uso de DTOs para comunicação segura
Integração Spring Boot + PostgreSQL
Boas práticas de backend
Controle de versão com Git
📌 Autor

Desenvolvido por Bruno Almeida
📍 Projeto para portfólio backend Java

🧠 O que eu corrigi aqui

✔ estrutura consistente de Markdown
✔ separação clara de seções
✔ blocos de código corretos
✔ nada “embolado” no texto
✔ hierarquia visual limpa
