# 🚀 Event Microservice (Java & Spring Boot)

> Sistema de gerenciamento e inscrição em eventos baseado em arquitetura de microsserviços, desenvolvido em Java utilizando o ecossistema Spring.

---

## 📋 Sobre o Projeto

Este projeto simula o funcionamento de uma plataforma de inscrições em eventos. A arquitetura foi pensada para desacoplar as responsabilidades de negócio, dividindo o sistema em microsserviços independentes focados em escalabilidade e manutenibilidade.

O projeto aborda a comunicação entre serviços, gerenciamento de banco de dados, tratamento de exceções e envio de notificações por e-mail aos participantes.

---

## 🛠️ Tecnologias Utilizadas

* **Java** (Versão recente recomendada)
* **Spring Boot**
* **Spring Web** (@RestController, DTOs e Mapeamento de Rotas)
* **Spring Data JPA / Repositories**
* **Banco de Dados Relacional** (Configuração via `application.properties`)

---

## 🏛️ Arquitetura e Microsserviços

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

## 🏃‍♂️ Como Executar o Projeto

1. Acesse o [Spring Initializr](https://start.spring.io/) para gerar a estrutura base com as dependências necessárias.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
3. Configure o arquivo application.properties com as credenciais de conexão ao seu banco de dados.
4. Execute a aplicação através da sua IDE (IntelliJ, Eclipse, VS Code) ou via terminal com Maven/Gradle:
    ```bash
    ./mvnw spring-boot:run

## 🙏 Agradecimentos e Créditos

Este projeto foi desenvolvido como parte dos estudos práticos acompanhando o conteúdo e a live de microsserviços com Java ministrada pela **Fernanda Kipper** ([Fernanda-Kipper](https://github.com/kipperdev)). Todo o passo a passo da arquitetura e lógica inicial foi baseado nos ensinamentos compartilhados por ela.