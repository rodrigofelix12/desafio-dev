# desafio-dev

## Requerimentos
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Intellij Idea Community](https://www.jetbrains.com/idea/download/?section=linux)
- [Intellij Idea Ultimate](https://www.jetbrains.com/idea/download/?section=linux)
- [Spring tools Suite](https://spring.io/tools)

## Para rodar o projeto
```shell
mvn spring-boot:run
```

## API's Disponíveis

Acessar a seguinte URL no seu navegador de preferência: http://localhost:8080
  Neste endereço é possível realizar o upload do arquivo CNAB.txt e visualizar uma tabela contendo os dados salvos a partir do arquivo enviado.

GET - http://localhost:8080/transactions (Para buscar todas as transações cadastradas)

POST - http://localhost:8080/upload (Passando como parâmetro o arquivo CNAB.txt disponível dentro da pasta resources do projeto)
