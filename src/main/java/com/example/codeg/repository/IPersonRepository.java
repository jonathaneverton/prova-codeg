package com.example.codeg.repository;

import com.example.codeg.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByCpf(String document);

    List<Person> findByGerenteIsTrue();
}
