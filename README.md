<h1 align="center"> -----> Prova CODE G <----- </h1>

![Link](./assets/linkedin.png) [Jonathan Everton](https://www.linkedin.com/in/jonathan-everton/)

# Índice
* [Descritivo](#Descritivo)
* [Tecnologias](#Tecnologias)
* [Configurações](#Configurações)
* [Funcionalidades](#Funcionalidades)
* [Regras de Negócio](#Regras-de-Negócio)
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
### Regras de Negócio
+ Permitir o CRUD de Projetos
+ Para cada Projeto devem ser informados 
  + nome
  + data de início
  + gerente responsável 
  + previsão de término
  + data real de término
  + orçamento total
  + descrição
  + status
+ Os projetos devem ser classificados em: *baixo risco, médio risco e alto risco*. A
    classificação de risco não é cadastrada no sistema.
+ A cada instante, o projeto deve estar em um status específico e único. Os status
  possíveis não são cadastrados no sistema e são: 
  + em análise
  + análise realizada
  + análise 
  + aprovada
  + iniciado
  + planejado
  + em andamento
  + encerrado
  + cancelado
+ Se um projeto foi mudado o status para *iniciado, em andamento ou encerrado* não pode
  mais ser excluído
+ O sistema não deve permitir o cadastro de um novo membro diretamente. Deve ser
  provida funcionalidade via web service, contendo nome e atribuição (cargo)
+ O sistema deve permitir associar membros aos projetos que tem atribuição funcionário

---
### URLs
### Home
```
http://localhost:8080/
```
#### Pessoa
```
- http://localhost:8080/person/viewPersonList
- http://localhost:8080/person/addPerson
- http://localhost:8080/person/editPerson/{idPessoa}
- http://localhost:8080/person/deletePerson/{idPessoa}
```
#### Projeto
```
- http://localhost:8080/project/viewProjectList
- http://localhost:8080/project/addProject
- http://localhost:8080/project/editProject/{idProject}
- http://localhost:8080/project/deleteProject/{idProject}
```
#### Membros (WEB-SERVICE)
```
- http://localhost:8080/api/member (POST)

Json:
{
"id": 1,
"projeto": 5,
"pessoa": 1
}

- http://localhost:8080/api/member (GET)
- http://localhost:8080/api/{idProjeto}/members (GET)
```

---
### Autor
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/4580771?v=4" width=115><br><sub>Jonathan Everton</sub>](https://github.com/jonathaneverton) |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------:|