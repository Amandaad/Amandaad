# Sistema Backend com Java (Spring Boot)

API REST simples para gerenciamento de tarefas.

## Requisitos
- Java 17+
- Maven 3.9+

## Como executar
```bash
mvn spring-boot:run
```

## Endpoints
Base URL: `http://localhost:8080/api/tasks`

- `GET /` → Lista tarefas
- `GET /{id}` → Busca tarefa por ID
- `POST /` → Cria tarefa
- `PUT /{id}` → Atualiza tarefa
- `DELETE /{id}` → Remove tarefa

## Exemplo de payload
```json
{
  "title": "Estudar Spring",
  "description": "Criar API REST",
  "completed": false
}
```
