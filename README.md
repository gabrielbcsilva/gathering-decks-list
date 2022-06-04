# gathering-decks-list
> Um jeito simples de manter seu Deck de cartas organizado


<h3 align="center">
    <img alt="Logo" title="#logo" width="170px" src="https://www.celsonunes.com.br/wp-content/uploads/2018/05/java-logo.png">
    <img alt="Logo" title="#logo" width="200px" src="https://1.bp.blogspot.com/-_IX8zH83dJk/Xva8BQtk_QI/AAAAAAAAH8Y/tgNzUIYVh0U7onxYQdim8TNB5PEwlgDtQCLcBGAsYHQ/s1600/thymeleaf.png">
   <img alt="Logo" title="#logo" width="100px" src="https://cdn-icons-png.flaticon.com/512/477/477154.png">
</h3>


  </a>
   <a href="https://github.com/gabrielbcsilva">
   <div align="center"> <img alt="Code by Gabriel Bruno" src="https://img.shields.io/badge/code%20by-Gabriel%20Bruno-black"></div>
  </a>
</p>

<p align="center">
  <a href="https://flutter.dev/docs">
    <img alt="Flutter" src="https://img.shields.io/badge/-Java-red">
  </a>
 
  <a href="https://dart.dev/guides">
    <img alt="Dart" src="https://img.shields.io/badge/-thymeleaf-green">
  </a>
</p>

## Gathering Deck List - Organize Seu Deck!

- [Sobre](#sobre)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Passo a Passo](#passo-a-passo)
- [Como contribuir](#como-contribuir)

<a id="sobre"></a>

## :interrobang: Sobre

Um _App_ que visa auxiliar jogadores do tão famoso Magic the Gathering a organizar seu Deck de cartas! Você poderá logar-se ver o deck de outros amigos e editar o seu, além de cadastrar novas cartas.
[Acesse Aqui](https://gathering-deck-java.herokuapp.com/login)
<a id="tecnologias-utilizadas"></a>

## :diamonds: Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- [Java](https://www.java.com/)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)




<a id="passo-a-passo"></a>

## - Passo a Passo

Clone este projeto ou baixe um novo projeto no site da Spring boot com JPA instalado.

     1. Configure sua classe de Banco de dados o código fica em application.properties

     2. Execute o comando .\mvnw spring-boot:run -e no terminal no caso do Windows
     
     3. Se não obtiver erros é só acessar localhost:8080!
     
     4. Crie um usuário na tabela gerada tb_usumtg
     
     5. O projeto do backend está separado e o link da documentação é esse https://documenter.getpostman.com/view/21229006/Uz5GobTk
     
     6. Há muitos detalhes a serem melhorados caso deseje contribuir é só realizar um fork do projeto, ajudará bastante.

     

**Tela 1**: Login.

Essa é a tela inicial:

<img alt="login" width="400px" src="./src/main/resources/static/img/login.png">

**Tela 2**: Home

 Essa tela de home está estática, mas é uma ideia de implementação

 <img alt="home" width="400px" src="./src/main/resources/static/img/home.png">
 
**Tela 3**: Usuários

 Tela de usuários, você não poderá excluir seu usuário. Apenas outros.


<img alt="users" width="300px" src="./src/main/resources/static/img/users.png">


**Tela 4**: Decks
 Tela de Decks, crie quantos quiser. Você só poderá editar o seu. Ficará disponível apenas a vizualiação de decks de amigos

<img alt="deck" width="400px" src="./src/main/resources/static/img/deckmanager.png">

**Tela 5**: Nova Carta para mandar para API
Não foi implementado mensagem de sucesso, porém poderá ser verificado na montagem do deck essa nova carta. Essa tela envia direto para API externa também hospedada na Heroku

<img alt="card" width="400px" src="./src/main/resources/static/img/novacarta.png">

<a id="como-contribuir"></a>

## :dart: Como contribuir

- Faça um _Fork_ deste repositório;
- Crie uma _branch_ com a sua feature: `git checkout -b my-feature`
- _Commit_ suas mudanças: `git commit -m 'feat: My new feature'`
- Faça um _push_ da sua branch: `git push origin my-feature`
