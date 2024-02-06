package com.example.codeg.service;

import com.example.codeg.model.Person;
import com.example.codeg.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository repository;

    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        repository.findAll().forEach(person -> personList.add(person));

        return personList;
    }

    public List<Person> getAllGerente() {
        return repository.findByGerenteIsTrue();
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).get();
    }

    public boolean saveOrUpdatePerson(Person person) {
        Person updatedPerson = repository.save(person);

        return repository.findById(updatedPerson.getId()).isPresent();
    }

    public boolean deletePerson(Long id) {
        repository.deleteById(id);

        return repository.findById(id).isPresent();
    }

}
