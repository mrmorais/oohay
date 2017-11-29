<img src="https://github.com/mrmorais/calcula-arvore/blob/master/res/img/oohay.png?raw=true"/>
Sistema em Java de indexação e busca de palavras em arquivos

O **oohaY!** foi desenvolvido por Maradona Morais e Daniel Marx como projeto requisito da avaliação da 3º unidade das disciplinas Linguagem de Programação II e Estruturas de Dados Básicas II. As features desenvolvidas no sistema são:

- Indexação, através de interface gráfica, de arquivos
  - Apresentando lista de arquivos indexados
  - Permite remoção de um arquivo indexado
  - Permite atualização de um arquivo já existente
- Busca por palavras
- Recurso de `autocorrect` no sistema de busca que sugere palavras caso nenhuma foi encontrada (similar ao conhecido "Você quis dizer ~........~ ?" do Google. Recurso desenvolvido utilizando o algoritmo da distância de Levenshtein
- Persistência das informações carregadas, o usuário pode fechar o sistema e quando abrir novamente, os arquivos e palavras indexadas continuarão existindo.

### Fazendo o build do projeto

oohaY! utiliza [Maven](https://maven.apache.org/) para controle de dependencias e build do código. O comando de execução para compilar as classes de oohaY! é

```
mvn compile
```

Os arquivos compilados ficarão localizados em `target/classes`

### Empacotando para .jar

A maneira mais fácil de distribuir e executar oohaY! é empacotando em arquivo `.jar`. Para isso, ainda utilizando Maven, execute o seguinte comando:

```
mvn package
```

Será criado o arquivo `oohay-x.x.jar` no diretório `target/`. Para executar este arquivo, permaneça na raiz do projeto e execute: 

```
java -jar target/oohay-x.x.jar
```
