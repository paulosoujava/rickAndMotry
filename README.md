# Rick and Morty
## _The best application has u see, (just kidin)_


Sistemas de pastas do aplicativo:
- Presenter
- - Responsavel pelas uis, foi usado o MVI, model view intent, para gerenciar as ações a atualizações de views
- Data
- - Responsável por frameworks externos, implementações de classes concretas
- Domain
- - Responsavel pela lógica do negocio, foi usado os use cases, para não ter que passar as interfaces de repositórioas direto ao view model
- ✨ Core ✨  
- - Base da aplicação, contendo classes seladas para o uso do MVI

 ## Features

- Cache com Retrofit, usando o interceptor
- Fetch em Characteres
- Fetch em Locations
- Fetch em Episodes
- Busca com filtros:
- Name | Status [ALIVE DEAD UNKNOWKN]
- Check de coneção com a internet

O app só faz a busca se a aplicação estiver on line, caso não esteja é exibido um toast

## O que foi utilizado:
```sh
JETPACK COMPOSE
HILT
RETROFIT
VIEW MODEL
SINGLE OF RESPOSABILITY
DEPENDECY INJECTION
DESIGN PATTERNS: SINGLETON, ABSTRACT FACTORY
REPOSITORY PATTERN
```

```sh
  ./gradlew build
    BUILD SUCCESSFUL in 36s

  ./gradlew connectedCheck
    BUILD SUCCESSFUL in 26s

  ./gradlew lintKotlin
   -- NÃO APLICADO --

```

## Melhorias para serem feitas:
- Mais testes
- Pagination
- Favorire (Room)
- Rotate Screen

## Telas:

<p float="left">
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/0.png" width="200" />
  <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/7.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/1.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/2.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/3.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/4.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/5.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/6.jpg" width="200" />



</p>
