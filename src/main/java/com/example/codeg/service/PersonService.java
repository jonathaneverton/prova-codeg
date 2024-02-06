package com.example.codeg.service;

import com.example.codeg.exceptions.CustomException;
import com.example.codeg.model.Person;
import com.example.codeg.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository repository;

//    public List<Person> getAllPerson() {
//        List<Person> personList = new ArrayList<>();
//        repository.findAll().forEach(person -> personList.add(person));
//
//        return personList;
//    }

    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();

        // Ordena por nome em ordem crescente
        repository.findAll(Sort.by(Sort.Order.asc("nome"))).forEach(personList::add);

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
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new CustomException("Não é possível excluir a pessoa devido a alguma condição específica.");
        }

        return repository.findById(id).isPresent();
    }

}
