package com.example.codeg.dto;

import com.example.codeg.model.Person;

import java.time.LocalDate;
import java.util.Date;

public record PersonDTO(String nome, LocalDate dataNascimento, String cpf, Boolean funcionario, Boolean gerente) {
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
