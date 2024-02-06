package com.example.codeg.dto;

import java.time.LocalDate;

public record ProjectDTO(String nome,
                         LocalDate datainicio,
                         LocalDate dataPrevisaoFim,
                         LocalDate dataFim,
                         String descricao,
                         String status,
                         Double orcament,
                         String risco) {
}
