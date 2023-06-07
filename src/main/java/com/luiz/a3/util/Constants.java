package com.luiz.a3.util;

public enum Constants {

    A("A");

    final private String valor;

    Constants(final String valor) {
        this.valor = valor;
    }

    public String getValor() { return valor; }
}
