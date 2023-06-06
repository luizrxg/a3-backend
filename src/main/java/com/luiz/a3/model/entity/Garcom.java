package com.luiz.a3.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "garcom")
public class Garcom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", nullable = false)
    private Long id;

    @Column(name = "nome", columnDefinition = "varchar(255)", nullable = false)
    private String nome;

    @Column(name = "cpf", columnDefinition = "int", nullable = false)
    private Long cpf;

    @Column(name = "dataNascimento", columnDefinition = "date", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "email", columnDefinition = "varchar(255)", nullable = false)
    private String email;

    @Column(name = "telefone", columnDefinition = "int", nullable = false)
    private Long telefone;

    @Column(name = "sexo", columnDefinition = "varchar(1)", nullable = false)
    private String sexo;

    @Column(name = "salario", columnDefinition = "int", nullable = false)
    private Long salario;

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
