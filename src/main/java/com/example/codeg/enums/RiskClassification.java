package com.example.codeg.enums;

public enum RiskClassification {
    BAIXO_RISCO,
    MEDIO_RISCO,
    ALTO_RISCO;

    // Implementação do método equals
    public boolean equals(String value) {
        return this.name().equals(value);
    }
}
