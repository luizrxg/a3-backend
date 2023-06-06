package com.luiz.a3.model.enums;

public enum SituacaoMesa {

    LIVRE("livre"),
    OCUPADA("ocupada"),
    RESERVADA("reservada");

    final private String valor;

    SituacaoMesa(
        final String valor
    ) {
        this.valor = valor;
    }

    public String getValor() { return valor; }
}
