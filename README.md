# SelecaoCasaPopular
## Projeto Desafio - Seleção de famílias aptas a ganharem uma casa popular

Este projeto implementa um sistema para gerenciar e selecionar famílias aptas a ganhar uma casa com base em critérios específicos.

## Funcionalidades

- Cadastro (CRUD) de pessoas e endereços.
- Cálculo de pontos baseado na renda familiar e no número de dependentes menores de idade.(Esse cáculo acontece ao salvar uma pessoa, no cadastro).
- Listagem de pessoas com pontuação superior a um valor especificado, ordenadas pela maior pontuação.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Hibernate - Persistência
- Flyway
- PostgreSQL
- JUnit - Teste unitários

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/sua-repositorio.git
   cd sua-repositorio

2. Na raiz da branch atual tem uma pasta chamada "desenvolvimento", dentro dela tem uma coleção para ser exportada para o POSTMAN para testar as APIs.

3. Tem Scripts versionados pelo Flyway que ao iniciar a aplicação será inserido 20 registros para teste.

4. É só clonar o projeto para sua IDEA Intellij e executar que irá funcionar.
