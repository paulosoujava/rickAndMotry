# Rick and Morty
## _The best application has u see, (just kidin)_


Sistemas de pastas do aplicativo:
- Presenter
--Responsavel pelas uis, foi usado o MVI, model view intent, para gerenciar as ações a atualizações de views
- Data
--Responsável por frameworks externos, implementações de classes concretas
- Domain
--Responsavel pela lógica do negocio, foi usado os use cases, para não ter que passar as interfaces de repositórioas direto ao view model
- ✨ Core ✨  
-- Base da aplicação, contendo classes seladas para o uso do MVI

- - ## Features

- Cache com Retrofit, usando o interceptor
- Fetch em Characteres
- Fetch em Locations
- Fetch em Episodes
- Busca com filtros:
- Name | Status [ALIVE DEAD UNKNOWKN]
- Check de coneção com a internet

O app só faz a busca se a aplicação estiver on line, caso não esteja é exibido um toast

#Telas:

<p float="left">

 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/1.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/2.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/3.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/4.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/5.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/6.jpg" width="200" />
 <img src="https://github.com/paulosoujava/rickAndMotry/blob/main/app/sampledata/7.jpg" width="200" />


</p>
