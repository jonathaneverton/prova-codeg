package com.example.codeg;

import java.util.Date;

public record PersonDTO(String nome, Date dataNascimento,String cpf, Boolean funcionario, Boolean gerente) {
}
