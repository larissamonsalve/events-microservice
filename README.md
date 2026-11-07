# Event Microservice (Java & Spring Boot)

> Sistema de gerenciamento e inscrição em eventos baseado em arquitetura de microsserviços, desenvolvido em Java utilizando o ecossistema Spring.

---

## Sobre o Projeto

Este projeto simula o funcionamento de uma plataforma de inscrições em eventos. A arquitetura foi pensada para desacoplar as responsabilidades de negócio, dividindo o sistema em microsserviços independentes focados em escalabilidade e manutenibilidade.

O projeto aborda a comunicação entre serviços, gerenciamento de banco de dados, tratamento de exceções e envio de notificações por e-mail aos participantes.

---

## Tecnologias Utilizadas

* **Java** (Versão recente recomendada)
* **Spring Boot**
* **Spring Web** (@RestController, DTOs e Mapeamento de Rotas)
* **Spring Data JPA / Repositories**
* **Banco de Dados Relacional** (Configuração via `application.properties`)

---

## Arquitetura e Microsserviços

O sistema é dividido nos seguintes componentes principais:

### 1. Microsserviço de Eventos (`Event Service`)
Responsável por gerenciar todo o ciclo de vida dos eventos e inscrições:
* Listagem de todos os eventos disponíveis.
* Filtro para retornar apenas eventos futuros (cuja data ainda não aconteceu).
* Cadastro de novos eventos no banco de dados.
* Processamento de novas inscrições de participantes em um evento específico.

### 2. Microsserviço de Mensageria (`Email Service`)
Responsável pelo disparo de notificações:
* Envio de e-mails de confirmação contendo remetente, corpo e assunto (`payload`).

---

## Endpoints da API

A aplicação disponibiliza as seguintes rotas principais:

### 1. Listar todos os eventos
* **GET** `/events`
* Retorna a lista completa de eventos cadastrados no sistema.

### 2. Listar eventos futuros
* **GET** `/events/upcoming`
* Retorna apenas os eventos cuja data é posterior à data atual.

### 3. Criar um novo evento
* **POST** `/events`
* **Exemplo de Body (JSON):**
  ```json
  {
    "maxParticipants": 20,
    "registeredParticipants": 0,
    "date": "25/12/2026",
    "title": "Workshop de Java e Microsserviços",
    "description": "Aprendendo a criar arquiteturas distribuídas com Spring Boot."
  }

### 4. Inscrever um participante em um evento
* **POST** `/events/{id}/register`
* **Exemplo de Body (JSON):**
 ```json
 {
  "participantEmail": "usuario@email.com"
  }
  ```

## Como Executar O Projeto

1. Acesse o [Spring Initializr](https://start.spring.io/) e selecione as seguintes configurações para gerar a estrutura base:
   * **Project:** Maven
   * **Language:** Java
   * **Spring Boot:** Versão estável recente (ex: 3.x)
   * **Packaging:** Jar
   * **Java:** 17 ou superior

2. Adicione as seguintes **dependências essenciais** no Spring Initializr antes de gerar o projeto:
   * **Spring Web:** Essencial para a construção de APIs RESTful e mapeamento dos controllers (@RestController).
   * **Spring Boot DevTools:** Auxilia no desenvolvimento acelerado com reinicialização automática da aplicação.
   * **Spring Data JPA:** Utilizado para a persistência e mapeamento objeto-relacional (ORM) com o banco de dados.
   * **H2 Database:** Banco de dados em memória leve e prático para execução e testes locais.
   * **Lombok:** Biblioteca de anotações para reduzir a escrita de códigos repetitivos (boilerplates).
   * **OpenFeign:** Cliente HTTP declarativo utilizado para facilitar a comunicação entre os microsserviços.

3. Clone este repositório:
   ```bash
   git clone [https://github.com/larissamonsalve/events-microservice.git](https://github.com/larissamonsalve/events-microservice.git)

4. Configure o arquivo application.properties com as credenciais de conexão ao seu banco de dados.

5. Execute a aplicação através da sua IDE (IntelliJ, Eclipse, VS Code) ou via terminal com Maven/Gradle:
    ```bash
    ./mvnw spring-boot:run
    
## Agradecimentos e Créditos

Este projeto foi desenvolvido como parte dos estudos práticos acompanhando o conteúdo e a live de microsserviços com Java ministrada pela **Fernanda Kipper** ([Fernanda-Kipper](https://github.com/Fernanda-Kipper)). Todo o passo a passo da arquitetura e lógica inicial foi baseado nos ensinamentos compartilhados por ela.