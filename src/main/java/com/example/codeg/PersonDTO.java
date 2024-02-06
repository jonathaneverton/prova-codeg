package com.example.codeg;

import java.time.LocalDate;
import java.util.Date;

public record PersonDTO(String nome, LocalDate dataNascimento, String cpf, Boolean funcionario, Boolean gerente) {
}
