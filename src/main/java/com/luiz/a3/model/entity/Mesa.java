package com.luiz.a3.model.entity;

import javax.persistence.*;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", nullable = false)
    private Long id;

    @Column(name = "numero", columnDefinition = "int", nullable = false)
    private Long numero;

    @Column(name = "situacao", columnDefinition = "varchar(10)", nullable = false)
    private String situacao;

    @Column(name = "capacidadeMaxima", columnDefinition = "int", nullable = false)
    private Long capacidadeMaxima;

    @Column(name = "idGarcom", columnDefinition = "int")
    private Long idGarcom;

    public Long getId() {
        return id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setCapacidadeMaxima(Long capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void setIdGarcom(Long idGarcom) {
        this.idGarcom = idGarcom;
    }

    public String getSituacao() {
        return situacao;
    }

    public Long getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public Long getIdGarcom() {
        return idGarcom;
    }
}
