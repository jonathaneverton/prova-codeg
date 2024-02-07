package com.example.codeg.repository;

import com.example.codeg.dto.PersonDTO;
import com.example.codeg.dto.ProjectDTO;
import com.example.codeg.enums.RiskClassification;
import com.example.codeg.enums.StatusProject;
import com.example.codeg.model.Person;
import com.example.codeg.model.Project;
import com.example.codeg.service.PersonService;
import com.example.codeg.service.ProjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = "com.example.codeg")
class IProjectRepositoryTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProjectService projectService;

    @Test
    @DisplayName("Cadastrar Projeto com sucesso do DB")
    void testCreateProject() {
        // Dados de exemplo Pessoa
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = true;

        // Criação de PersonDTO
        PersonDTO personDTO = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);

        // Chamada do serviço para criar a pessoa
        Person createdPerson = personService.createPerson(personDTO);

        // Dados de exemplo Projeto
        String nomeProjeto = "Projeto 1";
        LocalDate data = LocalDate.now();
        String descricao = "Descrição do Projeto 1";
        String status = StatusProject.INICIADO.name();
        Double orcamento = 10000.0;
        String risco = RiskClassification.ALTO_RISCO.name();

        // Criação de ProjetcDTO
        ProjectDTO projectDTO = new ProjectDTO(nomeProjeto, data, data, data, descricao, status, orcamento, risco, createdPerson.getId());

        // Chamada do serviço para criar a projeto
        Project createdProject = projectService.createProject(projectDTO);

        // Verificar se o projeto foi criado corretamente
        assertNotNull(createdProject.getId());
        assertEquals(nomeProjeto, createdProject.getNome());
        assertEquals(data, createdProject.getDataInicio());
        assertEquals(data, createdProject.getDataPrevisaoFim());
        assertEquals(data, createdProject.getDataFim());
        assertEquals(data, createdProject.getDataFim());
        assertEquals(descricao, createdProject.getDescricao());
        assertEquals(status, createdProject.getStatus());
        assertEquals(orcamento, createdProject.getOrcamento());

        // Verificar se o gerente associado ao projeto não é nulo
        assertNotNull(createdProject.getGerente());
        // Verificar se o id da pessoa é o mesmo que o id do gerente associado ao projeto
        assertEquals(createdPerson.getId(), createdProject.getGerente().getId());
    }

    @Test
    @DisplayName("Não excluir projeto com status INICIADO")
    void testNotDeleteProjectIfStatusStarted() {
        // Dados de exemplo Pessoa
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = true;

        // Criação de PersonDTO
        PersonDTO personDTO = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);

        // Chamada do serviço para criar a pessoa
        Person createdPerson = personService.createPerson(personDTO);

        // Dados de exemplo Projeto
        String nomeProjeto = "Projeto 1";
        LocalDate data = LocalDate.now();
        String descricao = "Descrição do Projeto 1";
        String status = StatusProject.INICIADO.name();
        Double orcamento = 10000.0;
        String risco = RiskClassification.ALTO_RISCO.name();

        // Criação de ProjetcDTO
        ProjectDTO projectDTO = new ProjectDTO(nomeProjeto, data, data, data, descricao, status, orcamento, risco, createdPerson.getId());

        // Chamada do serviço para criar a projeto
        Project createdProject = projectService.createProject(projectDTO);

        // Tente excluir o projeto
        Boolean checkProject = projectService.deleteProject(createdProject.getId());
        assertFalse(checkProject, "O projeto não deve ter sido excluído.");
    }

    @Test
    @DisplayName("Não excluir projeto com status EM_ANDAMENTO")
    void testNotDeleteProjectIfStatusInProgress() {
        // Dados de exemplo Pessoa
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = true;

        // Criação de PersonDTO
        PersonDTO personDTO = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);

        // Chamada do serviço para criar a pessoa
        Person createdPerson = personService.createPerson(personDTO);

        // Dados de exemplo Projeto
        String nomeProjeto = "Projeto 1";
        LocalDate data = LocalDate.now();
        String descricao = "Descrição do Projeto 1";
        String status = StatusProject.EM_ANDAMENTO.name();
        Double orcamento = 10000.0;
        String risco = RiskClassification.ALTO_RISCO.name();

        // Criação de ProjetcDTO
        ProjectDTO projectDTO = new ProjectDTO(nomeProjeto, data, data, data, descricao, status, orcamento, risco, createdPerson.getId());

        // Chamada do serviço para criar a projeto
        Project createdProject = projectService.createProject(projectDTO);

        // Tente excluir o projeto
        Boolean checkProject = projectService.deleteProject(createdProject.getId());
        assertFalse(checkProject, "O projeto não deve ter sido excluído.");
    }

    @Test
    @DisplayName("Não excluir projeto com status ENCERRADO")
    void testNotDeleteProjectIfStatusClosed() {
        // Dados de exemplo Pessoa
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = true;

        // Criação de PersonDTO
        PersonDTO personDTO = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);

        // Chamada do serviço para criar a pessoa
        Person createdPerson = personService.createPerson(personDTO);

        // Dados de exemplo Projeto
        String nomeProjeto = "Projeto 1";
        LocalDate data = LocalDate.now();
        String descricao = "Descrição do Projeto 1";
        String status = StatusProject.ENCERRADO.name();
        Double orcamento = 10000.0;
        String risco = RiskClassification.ALTO_RISCO.name();

        // Criação de ProjetcDTO
        ProjectDTO projectDTO = new ProjectDTO(nomeProjeto, data, data, data, descricao, status, orcamento, risco, createdPerson.getId());

        // Chamada do serviço para criar a projeto
        Project createdProject = projectService.createProject(projectDTO);

        // Tente excluir o projeto
        boolean checkProject = projectService.deleteProject(createdProject.getId());
        assertFalse(checkProject, "O projeto não deve ter sido excluído.");
    }

}