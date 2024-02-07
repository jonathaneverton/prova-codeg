package com.example.codeg.repository;

import com.example.codeg.dto.PersonDTO;
import com.example.codeg.model.Person;
import com.example.codeg.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = "com.example.codeg")
class IPersonRepositoryTest {

    @Autowired
    private IPersonRepository repository;

    @Test
    @DisplayName("Cadastrar Pessoa com sucesso do DB")
    void testCreatePerson() {
        // Dados de exemplo
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = false;

        // Criação de PersonDTO
        PersonDTO personDTO = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);

        // Chamada do serviço para criar a pessoa
        Person createdPerson = createPerson(personDTO);

        // Verificar se a pessoa foi criada corretamente
        assertNotNull(createdPerson.getId());
        assertEquals(nome, createdPerson.getNome());
        assertEquals(dataNascimento, createdPerson.getDataNascimento());
        assertEquals(cpf, createdPerson.getCpf());
        assertEquals(funcionario, createdPerson.getFuncionario());
        assertEquals(gerente, createdPerson.getGerente());
    }

    @Test
    @DisplayName("Buscar Pessoa com sucesso do DB")
    void testFindPerson() {
        // Dados de exemplo
        String nome = "teste";
        LocalDate dataNascimento = LocalDate.now();
        String cpf = "111.111.111-11";
        Boolean funcionario = true;
        Boolean gerente = false;

        // Criação de PersonDTO
        PersonDTO data = new PersonDTO(nome, dataNascimento, cpf, funcionario, gerente);
        this.createPerson(data);
        Optional<Person> result = this.repository.findPersonByCpf(cpf);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Buscar Pessoa com sucesso do DB e não encontrar")
    void testFindPersonNotFound() {
        String doc = "111.111.111-12";
        PersonDTO data = new PersonDTO("teste", LocalDate.now(), "111.111.111-11", true, false);
        this.createPerson(data);
        Optional<Person> result = this.repository.findPersonByCpf(doc);

        assertThat(result.isPresent()).isFalse();
    }

    public Person createPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO);
        return repository.save(person);
    }
}