package com.luiz.a3.model.dto;

import com.luiz.a3.model.entity.Garcom;

import java.time.LocalDate;

public class GarcomDto {
    private Long id;

    private String nome;
    private Long cpf;
    private LocalDate dataNascimento;
    private String email;
    private Long telefone;
    private String sexo;
    private Long salario;

    public static GarcomDto converter(Garcom g) {
        var garcom = new GarcomDto();
        garcom.setId(g.getId());
        garcom.setNome(g.getNome());
        garcom.setCpf(g.getCpf());
        garcom.setDataNascimento(g.getDataNascimento());
        garcom.setEmail(g.getEmail());
        garcom.setTelefone(g.getTelefone());
        garcom.setSexo(g.getSexo());
        garcom.setSalario(g.getSalario());
        return garcom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public Long getSalario() {
        return salario;
    }
}
