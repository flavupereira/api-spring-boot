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
