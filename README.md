# FlowOrchestrator

# Sistema de Consultas — Kotlin + Spring Boot (MVP)

Este projeto é a fundação de um sistema de agendamento de consultas (appointments), desenvolvido em **Kotlin** com **Spring Boot**, com foco em **entregar valor funcional no menor tempo possível**.

# Filosofia do Projeto
“Executar antes de polir. Validar antes de escalar. Entregar antes de duvidar.”

## Objetivo
Construir um MVP (Minimum Viable Product) de um sistema de consultas, começando com:
- Cadastro de consultas via API REST.
- Listagem das consultas registradas.
- Armazenamento em memória (sem banco de dados, por enquanto).

---

## Tecnologias Utilizadas
- Kotlin
- Spring Boot
- Gradle (KTS)
- RESTful API
- Spring Data JPA, H2 Database
- Jakarta Bean Validation (JSR-380)
- StringWriter (CSV)

---



## Sobre o Projeto - ROADMAP
Este é um esboço inicial (MVP bruto), com foco total em entregar uma funcionalidade mínima usável sempre em 60 minutos para cada entrega.

- ✅ Persistência em banco de dados.
- ✅ Validações de dados.
- ✅ Tratamento de erros refinado.
- 70% - Exportação de relatórios (Geração de PDFs ou CSV com histórico de consultas)

Não há:
- Autenticação/autorização.
```
- Cadastro e login de usuários
- Autorização com JWT (usuário x admin)
```
- Filtros de busca (Isso aqui é sempre um bicho de 7 cabeças quando tento fazer no front hahaha, vamos lá)
```
- Por data específica
- Por intervalo de datas
- Por palavra-chave na descrição
```
- Persistência em MySQL, RDS, DynamoDB, Redis (Vamos ver o que vou conseguir inventar)
- Front-End leve pra essa primeira etapa em React ou Kotlin Compose Web (Angular eu já conheço um pouco, então estou explorando outras tecnologias)
- Exportação de relatórios (Geração de PDFs ou CSV com histórico de consultas)
```
- Filtros aplicados no CSV
- Geração de PDF (usando OpenPDF/iText)
```
- Validações avançadas (Evitar conflito de horários, campos compostos, etc. O que fiz ficou um pouco furreca, então vou melhorar)


- Relatório de uso
```
Total de consultas por dia/mês
Dashboards simples
```
- Testes automatizados (Testes de integração e validação de regras. Conheço MUITO de testes unitários etc, mas sei NADA em Kotlin, então vamos validar esse conhecimento)
```
- Testes de integração para endpoints
- Testes unitários de validação e serviço
```
- Front-end
```
- Tela de agendamento
- Lista com filtros e exportação
```

### Tudo isso será evoluído nas próximas etapas. 

---

## ✅ Funcionalidades Atuais

### 🔹 1. Cadastro de Consultas (POST `/appointments`)
- Armazena uma nova consulta com:
    - Nome do paciente
    - Data e hora no formato `yyyy-MM-ddTHH:mm`
    - Descrição
- Persistência via **banco de dados H2 em memória**
- Validações aplicadas (com mensagens de erro legíveis)

### 🔹 2. Listagem de Consultas (GET `/appointments`)
- Endpoint: `GET /appointments`
- Retorna todas as consultas cadastradas até o momento

### 🔹 3. Filtro por nome do paciente
- Endpoint: `GET /appointments?patientName=ana`
- Retorna todas as consultas cujo nome do paciente **contém** o termo informado (case-insensitive)

---

### 🔹 4. Exportação em CSV
- Endpoint: `GET /appointments/export`
- Gera um arquivo `.csv` com todas as consultas cadastradas
- Download forçado via header `Content-Disposition`

---

### Persistência
- Banco: **H2 (in-memory)**
- JPA + Hibernate
- Console web: [http://localhost:8183/h2-console](http://localhost:8183/h2-console)
    - JDBC URL: `jdbc:h2:mem:appointmentsdb`

### Validações com Bean Validation
- `@NotBlank`, `@Pattern`, etc.
- Erros tratados via `@ControllerAdvice` e retornados como JSON
- Padrão de mensagens claras para facilitar o consumo por frontend
- Retorno amigável ao cliente em JSON:

```json
{
  "patientName": "O nome do paciente é obrigatório.",
  "dateTime": "Formato de data/hora inválido. Use o padrão yyyy-MM-ddTHH:mm",
  "description": "A descrição é obrigatória."
}
```

---


## Como Executar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/xAzKaR/FlowOrchestrator.git
cd FlowOrchestrator

./gradlew bootRun

```

### 2. Exemplo de uso: Criar Consulta (POST /appointments)

```
{
"patientName": "Fulana",
"dateTime": "2025-08-10T14:30",
"description": "Retorno de exames"
}
```

### 3. Exemplo de uso: Listar Consultas (GET /appointments)

```
{
	"id": 5,
	"patientName": "Fulanaura Pistoleira",
	"dateTime": "2025-08-06T10:00",
	"description": "Consulta de rotina"
}
```

### 4. Exemplo de uso: Exportar para CSV (GET /appointments/export)

```
ID,Patient Name,Date Time,Description
"1","Fulana Fulaneira","2025-08-06T10:00","Consulta de rotina"
"2","Fulanada Furiosa","2025-08-06T10:00","Consulta de rotina"
"3","Eita Fulana","2025-08-06T10:00","Consulta de rotina"
"4","Fulanuda Furadeira","2025-08-06T10:00","Consulta de rotina"
"5","Fulanaura Pistoleira","2025-08-06T10:00","Consulta de rotina"
```

## Documentação é fundamental para a vida do software, documente!