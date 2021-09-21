<div align="center" id="top"> 
  <img src="./.github/app.gif" alt="Spring_react_todo" />

  &#xa0;

  <!-- <a href="https://spring_react_todo.netlify.app">Demo</a> -->
</div>

<h1 align="center">Spring_react_todo</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/Abdelouahedd/spring_react_todo?color=56BEB8">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/Abdelouahedd/spring_react_todo?color=56BEB8">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/Abdelouahedd/spring_react_todo?color=56BEB8">

  <img alt="License" src="https://img.shields.io/github/license/Abdelouahedd/spring_react_todo?color=56BEB8">

  <!-- <img alt="Github issues" src="https://img.shields.io/github/issues/Abdelouahedd/spring_react_todo?color=56BEB8" /> -->

  <!-- <img alt="Github forks" src="https://img.shields.io/github/forks/Abdelouahedd/spring_react_todo?color=56BEB8" /> -->

  <img alt="Github stars" src="https://img.shields.io/github/stars/Abdelouahedd/spring_react_todo?color=56BEB8" /> 
</p>

<!-- Status -->

<!-- <h4 align="center"> 
	🚧  Spring_react_todo 🚀 Under construction...  🚧
</h4> 

<hr> -->

<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <!-- <a href="#sparkles-features">Features</a> &#xa0; | &#xa0; -->
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#memo-license">License</a> &#xa0; | &#xa0;
  <a href="https://github.com/Abdelouahedd" target="_blank">Author</a>
</p>

<br>

## :dart: About ##

This project is a basic CRUD application for to-do list using spring boot with Reactjs.
The purpose of this project is the test many technologies of CI/CD as you see in the project you will find Jenkins file, azure pipeline file..

## :rocket: Technologies ##

The following tools were used in this project:

- [Spring](https://spring.io/)
- [Maven](http://maven.apache.org/)
- [Java 11](https://www.java.com/)
- [Node.js](https://nodejs.org/en/)
- [React](https://pt-br.reactjs.org/)
- [MySQL](https://www.mysql.com/fr/)
- [Docker](https://www.docker.com/)

## :white_check_mark: Requirements ##

Before starting :checkered_flag:, you need to have [Git](https://git-scm.com) and [Docker](https://www.docker.com/) installed.
If you want to use the app without creating your images,you need [Node.js](https://nodejs.org/en/),[Java 11](https://www.java.com/),[MySQL](https://www.mysql.com/fr/)
and [Maven](http://maven.apache.org/)

## :checkered_flag: Starting ##
- If you want to build images and run the app as container  : 
```bash
# Clone this project
$ git clone https://github.com/Abdelouahedd/spring_react_todo

# Access
$ cd spring_react_todo

# Install dependencies
$ docker-compose build

# Run the project
$ docker-compose up

# The server will initialize in the <http://localhost:80>
```
- If you want to run the app in local : 
 Before that you have to create instance of mysql db :
```bash
# Clone this project
$ git clone https://github.com/Abdelouahedd/spring_react_todo

# Access To back end
$ cd spring_react_todo/back-end

# Install dependencies
$ mvn clean install

# Run the project
$ mvn spring-boot:run

# The server will initialize in the <http://localhost:8080>

# Access To front end
$ cd spring_react_todo/front_end

# Install dependencies
$ npm install

# Run the project
$ npm start

# The server will initialize in the <http://localhost:3000>

```


## :memo: License ##

This project is under license from MIT. For more details, see the [LICENSE](LICENSE.md) file.


Made with  <span style="color: #e25555;">&#9829;</span>  by <a href="https://github.com/Abdelouahedd" target="_blank">Abdelouahedd</a>

&#xa0;

<a href="#top">Back to top</a>
