<h1 align="center"> -----> Prova CODE G <----- </h1>

# Índice
* [Descritivo](#Descritivo)
* [Configurações](#Configurações)
* [Funcionalidades](#Funcionalidades)
* [URLs](#URLs)
* [Autor](#Autor)

---
### Descritivo
É um sistema desenvolvido em Rest que gerencia o portifólio de projetos de uma empresa.
E possui um web service para associar membros a um projeto.

---
### Tecnologias
- SpringBoot
- Maven
- Java
- JSP
- Bootstrap
- JUnit
- MVC
- PostgreSQL
- H2
- Git
- Web Service

---
### Configurações
#### ![git](./assets/git.png) Clone este repositório
```bash 
# Clonar repositório
$ git clone https://github.com/jonathaneverton/prova-codeg.git
```
- Abra o projeto em sua IDE preferida, usei o IntelliJ
- Dê reload no Maven
- Crie uma base de dados no PostgreSQL com o nome de *portifolio* ou altere o nome da base e as credenciais no arquivo *application.properties*
- Rode a aplicação

---
### Funcionalidades

+ `Funcionalidade 1`: Cadastrar Pessoa
+ `Funcionalidade 2`: Editar Pessoa
+ `Funcionalidade 3`: Listar Pessoas
+ `Funcionalidade 4`: Excluir Pessoas

- `Funcionalidade 5`: Cadastrar Projeto
- `Funcionalidade 6`: Editar Projeto
- `Funcionalidade 7`: Listar Projetos
- `Funcionalidade 8`: Excluir Projetos

+ `Funcionalidade 9`: Cadastrar Projeto
+ `Funcionalidade 10`: Editar Projeto
+ `Funcionalidade 11`: Listar Projetos
+ `Funcionalidade 12`: Excluir Projetos

- `Funcionalidade 13`: Associar membro a um projeto (web-service)
- `Funcionalidade 14`: Excluir membro de um projeto (web-service)
- `Funcionalidade 15`: Listar membros de um projeto (web-service)

---
### URLs
### Pessoa
```
- http://localhost:8080/viewPersonList
- http://localhost:8080/addPerson
- http://localhost:8080/editPerson/{idPessoa}
- http://localhost:8080/deletePerson/{idPessoa}
```
####  - Projeto
```
- http://localhost:8080/viewProjectList
- http://localhost:8080/addProject
- http://localhost:8080/editProject/{idProject}
- http://localhost:8080/deleteProject/{idProject}
```
####  - Membros (WEB-SERVICE)
```
- http://localhost:8080/api/member
- http://localhost:8080/addProject
- http://localhost:8080/editProject/{idProject}
- http://localhost:8080/deleteProject/{idProject}
```

---
### Autor
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/4580771?v=4" width=115><br><sub>Jonathan Everton</sub>](https://github.com/jonathaneverton) |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------:|