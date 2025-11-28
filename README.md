# 📋 Sistema de Agendamento de Consultas Médicas - Voll.med

## 📖 Descrição

Sistema backend desenvolvido em Spring Boot para gerenciamento de consultas médicas, incluindo cadastro 
de médicos, pacientes, agendamento e cancelamento de consultas com validações de negócio. API Rest completa para aplicação Voll.med.

## 🚀 Tecnologias Utilizadas

- **Java 17**

- **Spring Boot 3.0.0**

- **Spring Security** com autenticação JWT

- **Spring Data JPA**

- **MySQL** com Flyway para migrações

- **Lombok**

- **Bean Validation**

- **SpringDoc OpenAPI 2.0.2** para documentação da API

- **Maven**

- **Spring Boot DevTools** para desenvolvimento

- **Flyway** para versionamento de banco de dados

## 📋 Funcionalidades

## 🔐 Autenticação e Segurança

- Autenticação JWT com Auth0 Java JWT

- Controle de acesso por roles

- Configuração CORS para frontend

- Spring Security para proteção de endpoints

## 👨‍⚕️ Gestão de Médicos

- Cadastro, listagem, atualização e exclusão lógica de médicos

- Filtragem por especialidade

- Controle de status (ativo/inativo)

- Detalhamento individual

## 👤 Gestão de Pacientes

- Cadastro, listagem, atualização e exclusão lógica de pacientes

- Paginação de resultados

- Controle de status ativo

## 📅 Gestão de Consultas

- Agendamento de consultas com validações:

   Horário de funcionamento da clínica (7h-18h, exceto domingos)

   Antecedência mínima de 30 minutos

   Médico disponível no horário

   Paciente e médico ativos

   Paciente não pode ter mais de uma consulta no mesmo dia

   Cancelamento de consultas com motivo obrigatório

   Escolha automática de médico quando não especificado

## 🏗 Estrutura do Projeto

```
src/main/java/med/vol/api/
├── config/
│   └── CorsConfiguration.java
├── controller/
│   ├── AutenticacaoController.java
│   ├── ConsultaController.java
│   ├── MedicoController.java
│   └── PacienteController.java
├── domain/
│   ├── consulta/
│   │   ├── validacao/
│   │   │   ├── agendamento/
│   │   │   └── cancelamento/
│   │   ├── AgendaDeConsultas.java
│   │   ├── Consulta.java
│   │   └── ConsultaRepository.java
│   ├── medico/
│   ├── paciente/
│   └── usuario/
├── infra/
│   └── security/
├── config/
└── ApiApplication.java

src/main/resources/
├── db/
│   └── migration/
│       ├── V1__creat_table_medico.sql
│       ├── V2__alter-table-medicos-add-column-telefone.sql
│       ├── V3__alter-table-medicos-add-column-ativo.sql
│       ├── V4__create-table-pacientes.sql
│       ├── V5__creat_table_usuarios.sql
│       └── V6__creat_table_consulta.sql
└── application.properties

```

##🔧 Configuração e Execução

**Pré-requisitos**

- Java 17

- Maven 3.6+

- MySQL 8.0+

- IDE de sua preferência (Spring Tools Suite, IntelliJ, VS Code)

## 📋 Configuração do Banco de Dados

1. Crie o banco de dados MySQL:
   ```
   CREATE DATABASE vollmed_api;
   ````
2. Configure as credenciais no application.properties:

   ```
 spring.datasource.url=jdbc:mysql://localhost:3306/vollmed_api
 spring.datasource.username=root
 spring.datasource.password=root

 spring.jpa.show-sql=true
 spring.jpa.properties.hibernate.format_sql=true

 # Configuração JWT
 api.security.token.secret=${JWT_SECRET:12345678}

 ```
## 🚀 Executando a Aplicação

1. **Clone o repositório:**
`´`
bash
git clone [url-do-repositorio]
```
2. **Configure o banco de dados no arquivo application.properties**

3. Execute a aplicação:
```
bash
mvn spring-boot:run
```
4. **Acesse a documentação da API:**
```
text
http://localhost:8080/swagger-ui.html
``´

## 📊 Migrações de Banco (Flyway)
O projeto utiliza Flyway para versionamento e gerenciamento de esquema de banco de dados.
As migrações são executadas automaticamente na inicialização da aplicação.

### Estrutura das Migrações

**V1__creat_table_medico.sql**

- Cria tabela de médicos com dados básicos e endereço

- Campos: id, nome, email, crm, especialidade, endereço completo

**V2__alter-table-medicos-add-column-telefone.sql**

- Adiciona coluna telefone na tabela médicos

**V3__alter-table-medicos-add-column-ativo.sql**

- Adiciona coluna ativo para controle de exclusão lógica

- Define todos os registros existentes como ativos

**V4__create-table-pacientes.sql**

- Cria tabela de pacientes com estrutura similar a médicos

- Inclui CPF e controle de ativo

**V5__creat_table_usuarios.sql**

- Cria tabela de usuários para autenticação

- Campos: id, login, senha

**V6__creat_table_consulta.sql**

- Cria tabela de consultas

- Relacionamentos com médicos e pacientes

- Campo de data/hora para age

## 📚 Endpoints da API

## 🔐 Autenticação

- POST /login - Autenticação e obtenção de token JWT

## 👨‍⚕️ Médicos

- POST /medicos - Cadastrar médico

- GET /medicos - Listar médicos ativos (paginação)

- PUT /medicos - Atualizar médico

- DELETE /medicos/{id} - Exclusão lógica

- GET /medicos/{id} - Detalhar médico

## 👤 Pacientes

- POST /pacientes - Cadastrar paciente

- GET /pacientes - Listar pacientes ativos (paginação)

- PUT /pacientes - Atualizar paciente

- DELETE /pacientes/{id} - Exclusão lógica

##📅 Consultas

- POST /consultas - Agendar consulta

- DELETE /consultas - Cancelar consulta (requer motivo)

## 🛡 Validações de Negócio

### Agendamento de Consultas

✅ Horário de funcionamento (7h-18h, exceto domingos)

✅ Antecedência mínima de 30 minutos

✅ Médico disponível no horário

✅ Paciente e médico ativos

✅ Paciente não pode ter mais de uma consulta no mesmo dia

✅ Especialidade obrigatória quando médico não é escolhido

Cancelamento de Consultas
✅ Motivo obrigatório para cancelamento

✅ Validações específicas de cancelamento

## 🔒 Segurança

- Autenticação via JWT com Auth0

- Proteção de endpoints sensíveis com Spring Security

- Configuração CORS para frontend React (localhost:3000)

- Todas as requisições (exceto login) requerem token Bearer

- Secret JWT configurável via variável de ambiente

## 🧪 Testes

### Executando os Testes
```
bash
mvn test
```
### Teste de Contexto
O projeto inclui testes básicos de contexto Spring para validar a configuração da aplicação.

