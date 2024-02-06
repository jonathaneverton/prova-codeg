package com.example.codeg.repository;

import com.example.codeg.PersonDTO;
import com.example.codeg.model.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.*;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class IPersonRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    IPersonRepository repository;

    @Test
    @DisplayName("Buscar Pessoa com sucesso do DB")
    void findPersonCase1() {
        String doc = "111.111.111-11";
        PersonDTO data = new PersonDTO("teste", LocalDate.now(), "111.111.111-11", true, false);
        this.createPerson(data);

        Optional<Person> result = this.repository.findPersonByCpf(doc);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Buscar Pessoa com sucesso do DB e não encontrar")
    void findPersonCase2() {
        String doc = "111.111.111-12";
        PersonDTO data = new PersonDTO("teste", LocalDate.now(), "111.111.111-11", true, false);
        this.createPerson(data);

        Optional<Person> result = this.repository.findPersonByCpf(doc);

        assertThat(result.isPresent()).isFalse();
    }

    private Person createPerson(PersonDTO personDTO) {
        Person person = new Person(personDTO);
        this.entityManager.persist(person);
        return person;
    }

}