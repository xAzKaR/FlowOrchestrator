# FlowOrchestrator

# Sistema de Consultas — Kotlin + Spring Boot (MVP)

Este projeto é a fundação de um sistema de agendamento de consultas (appointments), desenvolvido em **Kotlin** com **Spring Boot**, com foco em **entregar valor funcional no menor tempo possível**.

## Objetivo
Construir um MVP (Minimum Viable Product) de um sistema de consultas, começando com:
- Cadastro de consultas via API REST.
- Listagem das consultas registradas.
- Armazenamento em memória (sem banco de dados, por enquanto).

---

## Tecnologias Utilizadas
- Kotlin
- Spring Boot
- Gradle
- RESTful API

---



## Sobre o Projeto - ROADMAP
Este é um esboço inicial (MVP bruto), com foco total em entregar uma funcionalidade mínima usável sempre em 60 minutos para cada entrega.

- ✅ Persistência em banco de dados.
- ✅ Validações de dados.
- ✅ Tratamento de erros refinado.

Não há:
- Autenticação/autorização.
- Filtros de busca (Isso aqui é sempre um bicho de 7 cabeças quando tento fazer no front hahaha, vamos lá)
- Persistência em MySQL, RDS, DynamoDB, Redis (Vamos ver o que vou conseguir inventar)
- Front-End leve pra essa primeira etapa em React ou Kotlin Compose Web (Angular eu já conheço um pouco, então estou explorando outras tecnologias)
- Exportação de relatórios (Geração de PDFs ou CSV com histórico de consultas)
- Validações avançadas (Evitar conflito de horários, campos compostos, etc. O que fiz ficou um pouco furreca, então vou melhorar)
- Testes automatizados (Testes de integração e validação de regras. Conheço MUITO de testes unitários etc, mas sei NADA em Kotlin, então vamos validar esse conhecimento)

### Tudo isso será evoluído nas próximas etapas. 

---

## ✅ Funcionalidades Atuais

### 1. Cadastro de Consultas (POST `/appointments`)
- Armazena uma nova consulta com:
    - Nome do paciente
    - Data e hora no formato `yyyy-MM-ddTHH:mm`
    - Descrição
- Persistência via **banco de dados H2 em memória**
- Validações aplicadas (com mensagens de erro legíveis)

### 2. Listagem de Consultas (GET `/appointments`)
- Retorna todas as consultas cadastradas até o momento

### Persistência
- Banco: **H2 (in-memory)**
- JPA + Hibernate
- Console web: [http://localhost:8183/h2-console](http://localhost:8183/h2-console)
    - JDBC URL: `jdbc:h2:mem:appointmentsdb`

### Validações com Bean Validation
- `@NotBlank`, `@Pattern`, etc.
- Erros tratados via `@ControllerAdvice` e retornados como JSON
- Padrão de mensagens claras para facilitar o consumo por frontend


## Como Executar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/xAzKaR/FlowOrchestrator.git
cd FlowOrchestrator

./gradlew bootRun

```