# Comandos uteis

### Se for a primeira vez que você executa esse comando, pode ser que o Maven baixe as dependencias necessárias para realizar a tarefa que você solicitou
#### É altamente recomendavel sempre consultar a documentação oficial do <a href="https://maven.apache.org" target="_blanck">Maven</a>

#### Encontrar uma biblioteca que você precisa <a href="https://mvnrepository.com/" target="_blanck">mvn repository</a>

#### Repositório central do maven para você compartilhar uma biblioteca sua com a comunidade <a href="https://repo.maven.apache.org/maven2/" target="_blanck">repo maven</a>


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

#### Executar um comando de maneira off-line
````
mvn -o test
````

### Entrar no repositório local
##### ir na pasta raiz do usuario da maquina exemplo no linux: cd /home/usuario
````
cd /home/alexandre
ls .m2
cd .m2/repository
cat "digitar a biblioteca que você deseja visualizar.pom"
nano "digitar a biblioteca que você deseja visualizar.pom" (estou utilizando o editor nano, poderia ser o vim ou outro)

exemplo junit:
cd /home/alexandre/.m2/repository/junit/junit/4.12
nano junit-4.12.pom

````

## Ciclo de vida, fases do maven 
````
validate - validar se o projeto está correto e todas as informações necessárias estão disponíveis

compile - compila o código fonte do projeto

test - teste o código-fonte compilado usando uma estrutura de teste de unidade adequada. Esses testes não devem exigir que o código seja empacotado ou implantado

package - pega o código compilado e o empacota em seu formato distribuível, como um JAR.

verify - executar quaisquer verificações nos resultados dos testes de integração para garantir que os critérios de qualidade sejam atendidos

install - instala o pacote no repositório local, para uso como dependência em outros projetos localmente

deploy - feito no ambiente de compilação, copia o pacote final para o repositório remoto para compartilhamento com outros desenvolvedores e projetos

exemplo: quero gerar .jar ou .war do projeto
mvn package (ele vai rodar automaticamente o mvn validate, mvn compile, mvn test e mvn package.
````
##### mais informações <a href="https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html">lifecycle maven</a>

### Gerar um relatório com PMD 

#### mvn pmd é um plugin que gera um relatório de possiveis bugs no seu codigo. link <a href="https://maven.apache.org/plugins/maven-pmd-plugin/" target="_blank">maven pmd plugin</a> e <a href="https://maven.apache.org/plugins/maven-pmd-plugin/pmd-mojo.html" target="_blanck">documentação pmd</a>

##### vai gerar um arquivo pmd.html (relatório) no diretorio /target/site do seu projeto
````
mvn pmd:pmd
````

##### falhar o teste se existe alguma pendência a ser corrigida no codigo
````
mvn pmd:check
````

### executar o plugin que você deseja automaticamente numa fase especifica
#### Neste exemplo, vamos executar pmd:check na fase mvn verify
````
Colocar esse codigo no pom.xml

<build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-pmd-plugin</artifactId>
        <version>3.9.0</version>
        <executions>
        	<execution>
	        	<phase>verify</phase>
	        	<goals>
        			<goal>check</goal>
        		</goals>	
        	</execution>
        </executions>
      </plugin>
    </plugins>
  </build>
````
#### para maiores informações a respeito do assunto acima, entrar no  <a href="https://maven.apache.org/plugins/maven-pmd-plugin/usage.html" target="_blanck">link</a>
