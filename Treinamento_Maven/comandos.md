# Comandos uteis

### Se for a primeira vez que você executa esse comando, pode ser que o Maven baixe as dependencias necessárias para realizar a tarefa que você solicitou
#### É altamente recomendavel sempre consultar a documentação oficial do <a href="https://maven.apache.org">Maven</a>
#### Para executar o projeto
````
mvn compile
````

#### Para limpar o diretorio target
````
mvn clean
````

#### Para testar sua aplicação
````
mvn test
````
#### Para gerar um relatório de testes (uma das formas é com o surefire-report)
````
mvn surefire-report:report
````
#### Para gerar o executavel do projeto, exemplo: .jar ou .war do projeto
````
mvn package
````
#### 
