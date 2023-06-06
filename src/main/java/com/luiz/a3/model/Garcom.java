package com.luiz.a3.model;

import java.time.LocalDate;

public class Garcom {
    private final String nome;
    private final Long cpf;
    private final LocalDate dataNascimento;
    private final String email;
    private final Long telefone;
    private final String sexo;
    private final Long salario;

    public Garcom(
        final String nome,
        final Long cpf,
        final LocalDate dataNascimento,
        final String email,
        final Long telefone,
        final String sexo,
        final Long salario
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.salario = salario;
    }

    public String getNome() { return nome; }

    public Long getCpf() { return cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public String getEmail() { return email; }

    public Long getTelefone() { return telefone; }

    public String getSexo() { return sexo; }

    public Long getSalario() { return salario; }
}
