# Projeto para aprendizagem do Maven

Para informações mais precisas https://maven.apache.org/

Para baixar, entrar e escolher o arquivo de acordo com o seu sistema operacional https://maven.apache.org/download.cgi

# Apos baixar, instalando o Apache Maven

### No Linux
````````
unzip apache-maven-3.5.3-bin.zip ou tar xzvf apache-maven-3.5.3-bin.tar.gz
````````
colocar o local do arquivo nas varivaeis de ambiente do PATH
exemplo linux ou mac:

#### Observação importante:
Colocar o java e jdk também nas variaveis de ambiente (caminho da pasta bin)

Ctrl + Alt + G para entrar no terminal (vou usar o editor nano do linux)

##### na pasta /home/user digite: 

nano .bash_profile e edite seu arquivo com os comando abaixo (caminho PATH e maven)

````````
echo $JAVA_HOME
````````
caminho ... que você deixou o maven, espeficicamente a paste BIN
````````
/Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home

export PATH=/home/alexandre/apache-maven-3.5.3/bin:$PATH
````````
verificar no terminal se o maven esta instalado
````````
mvn -v
````````

Configurar as variaveis de ambiente no windows

Entre como administrador pelo terminal Ctrl + R digite cmd
````````
colocar o caminho de onde você colobou a pasta bin do Maven
setx PATH "%PATH%;C:\minha\nova\pasta"
````````

# No Windows 

Exemplo que serve para qualquer variavel de ambiente:

usando Crtl + R digite control

##### Windows 10

entre no Painel de controle > Sistema e segurança > Sistema > Configurações avançadas do sistema
<img src="https://github.com/alexandreximenes/java/blob/master/Treinamento_Maven/prints/1.PNG" />

### Clique em variaveis de ambiente

<img src="https://github.com/alexandreximenes/java/blob/master/Treinamento_Maven/prints/2.PNG" />

### Escolha a variavel de ambiente PATH e clique em editar

<img src="https://github.com/alexandreximenes/java/blob/master/Treinamento_Maven/prints/3.PNG" />

### Clique em (Novo) e coloque o caminho do diretorio bin do seu maven, java, jdk

<img src="https://github.com/alexandreximenes/java/blob/master/Treinamento_Maven/prints/4.PNG" />

### Para ver se tudo deu certo abra uma nova janela do terminal

#### digite
````````
mvn -v
````````

#### exemplo do comportamento esperado no meu computador

Apache Maven 3.5.3</br>
Maven home: C:\Users\Programmer\maven\apache-maven-3.5.3\bin\..</br>
Java version: 1.8.0_161, vendor: Oracle Corporation</br>
Java home: C:\Program Files\Java\jre1.8.0_161</br>
Default locale: pt_BR, platform encoding: Cp1252</br>
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"</br>


#### Windows 8

Arraste o ponteiro do Mouse (Rato) até o canto inferior Direito da tela</br>
Clique no ícone Pesquisar e digite Painel de Controle</br>
Clique em -> Painel de Controle -> Sistema -> Avançado</br>
Clique em Variáveis de Ambiente, em Variáveis do Sistema, localize PATH e clique nele.</br>
Na janelas Editar, modifique PATH adicionando a localização da classe para o valor de PATH.</br> 
Caso você não tenha o item PATH, será possível optar por adicionar uma nova variável e adicionar PATH como o nome e o local da classe como o valor.
Feche a janela.

#### Windows 7

Selecione Computador no menu Iniciar</br>
Relacionar o item</br>
Escolha Propriedades do Sistema no menu de contexto</br>
Clique na guia Definições avançadas do sistema > Avançado</br>
Clique em Variáveis de Ambiente, em Variáveis do Sistema, localize PATH e clique nele.</br>
Na janelas Editar, modifique PATH adicionando a localização da classe para o valor de PATH.</br> 
Caso você não tenha o item PATH, será possível optar por adicionar uma nova variável e adicionar PATH como o nome e o local da classe como o valor.

#### Windows XP

Iniciar -> Painel de Controle -> Sistema -> Avançado</br>
Clique em Variáveis de Ambiente, em Variáveis do Sistema, localize PATH e clique nele.</br>
Na janelas Editar, modifique PATH adicionando a localização da classe para o valor de PATH.</br> 
Caso você não tenha o item PATH, será possível optar por adicionar uma nova variável e adicionar PATH como o nome e o local da classe como o valor.
Feche a janela.

#### Windows Vista

Clique com o botão direito do mouse no ícone Meu computador</br>
Escolha Propriedades no menu de contexto</br>
Clique na guia Avançado (link Definições avançadas do sistema no Vista)</br>
Na janelas Editar, modifique PATH adicionando a localização da classe para o valor de PATH.</br> 
Caso você não tenha o item PATH, será possível optar por adicionar uma nova variável e adicionar PATH como o nome e o local da classe como o valor.

#### Boa sorte e bons estudos!</br></br>
<a href="https://github.com/alexandreximenes/">Alexandre Ximenes</a>
