package com.example.codeg.dto;

import com.example.codeg.model.Person;

import java.time.LocalDate;

public record ProjectDTO(String nome,
                         LocalDate datainicio,
                         LocalDate dataPrevisaoFim,
                         LocalDate dataFim,
                         String descricao,
                         String status,
                         Double orcament,
                         String risco,
                         Long gerente) {
}
