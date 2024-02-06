package com.example.codeg.model;

import com.example.codeg.PersonDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="PESSOA")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    private String cpf;

    private Boolean funcionario;

    private Boolean gerente;

    public Person() {

    }

    public Person(PersonDTO personDTO) {
        this.nome = personDTO.nome();
        this.cpf = personDTO.cpf();
        this.dataNascimento = personDTO.dataNascimento();
        this.gerente = personDTO.gerente();
        this.funcionario = personDTO.funcionario();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getGerente() {
        return gerente;
    }

    public void setGerente(Boolean gerente) {
        this.gerente = gerente;
    }
}
