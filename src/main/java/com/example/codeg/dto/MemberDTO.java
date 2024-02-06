package com.example.codeg.dto;

import com.sun.istack.NotNull;

public record MemberDTO(@NotNull PersonDTO person, @NotNull ProjectDTO projectDTO) {
}
