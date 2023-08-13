# Teste Turn2C

Este é o repositório do projeto Teste Turn2C. Este projeto é desenvolvido em Java 17 e Spring Boot e utiliza o Maven como gerenciador de dependências. Ele fornece uma API com documentação Swagger para interações e testes.

## Requisitos

- Java JDK 17 (Java Development Kit) instalado na máquina.
- Maven instalado na máquina.

## Iniciando o Projeto

### Via Linha de Comando (Terminal)

1. Clone este repositório para sua máquina:

https://github.com/RenatoBorgess/testeTurn2C.git


2. Navegue para o diretório do projeto:
    cd testeTurn2C

3. Compile e execute o projeto usando o Maven:
   mvn spring-boot:run


### Via IntelliJ IDEA

1. Abra o IntelliJ IDEA.

2. Vá em "File" > "Open" e selecione o diretório do projeto "testeTurn2C".

3. Aguarde até que o IntelliJ importe e construa o projeto.

4. No IntelliJ, navegue até a classe principal (geralmente rotulada como `TesteApplication`) e execute-a.

## Acessando a Interface do Usuário (Swagger)

Após iniciar o projeto, você pode acessar a interface do usuário Swagger para explorar e testar a API.

1. Abra seu navegador web.

2. Acesse o seguinte link:

http://localhost:8080/swagger-ui.html


Isso abrirá a interface Swagger, onde você poderá visualizar todos os endpoints disponíveis, seus detalhes e testá-los interativamente.

## Acessando o Console H2

Para acessar o console do H2, siga as instruções abaixo:

1. Certifique-se de que o projeto esteja em execução.

2. Abra o seu navegador web.

3. Acesse o seguinte URL:
   http://localhost:8080/h2-console/login.jsp

4. No formulário de login do H2, utilize as seguintes configurações:
- **JDBC URL:** `jdbc:h2:mem:testdb` 
- **Username:** `sa`
- **Password:** (deixe em branco)

5. Clique no botão "Connect".

Isso abrirá o console de administração do H2, onde você pode interagir com o banco de dados em memória. Lembre-se de que o URL JDBC e outras configurações podem variar com base nas configurações do seu projeto.

## Acessando a Coleção de Requests no Postman

Para acessar a coleção de requests no Postman, siga as instruções abaixo:

1. Abra o seu navegador web.

2. Acesse o seguinte link:
   https://www.postman.com/science-geoscientist-70624180/workspace/teste-turn2c/collection/25935851-c8d39519-cc73-43c8-9abf-e4e211aefc69?action=share&creator=25935851

3. Isso levará você para a página de compartilhamento da coleção no Postman.

4. Se você já estiver logado no Postman, será redirecionado automaticamente para a coleção no aplicativo Postman. Caso contrário, siga as instruções para fazer login ou criar uma conta.

5. Uma vez logado, você será levado para a coleção de requests "teste-turn2c". Nesta coleção, você encontrará uma lista de endpoints pré-configurados que podem ser usados para testar a API.

Lembre-se de que esta coleção de requests é específica para o projeto "teste-turn2c" e pode conter requests de teste e interações para os endpoints da API.


### Tecnologias Utilizadas
1. Spring Boot (3.1.2)
2. Java (17)
3. Spring Boot Starter Data JPA
4. Spring Boot Starter Validation
5. Spring Boot Starter Web
6. Flyway Core
7. H2 Database (2.2.220)
8. Lombok
9. Spring Boot Starter Test
10. SpringDoc OpenAPI Starter Web MVC UI (2.2.0)
11. Spring Boot Maven Plugin