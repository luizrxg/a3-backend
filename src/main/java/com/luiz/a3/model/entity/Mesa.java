package com.luiz.a3.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int", nullable = false)
    private Long id;

    @Column(name = "numero", columnDefinition = "int", nullable = false)
    private Long numero;

    @Column(name = "situacao", columnDefinition = "varchar(10)", nullable = false)
    private String situacao;

    @Column(name = "capacidade_maxima", columnDefinition = "int", nullable = false)
    private Long capacidadeMaxima;

    @Column(name = "id_garcom", columnDefinition = "int")
    private Long idGarcom;

    @Column(name = "id_garcom", columnDefinition = "int")
    private String nomeGarcom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Long capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public Long getIdGarcom() {
        return idGarcom;
    }

    public void setIdGarcom(Long idGarcom) {
        this.idGarcom = idGarcom;
    }

    public String getNomeGarcom() {
        return nomeGarcom;
    }

    public void setNomeGarcom(String nomeGarcom) {
        this.nomeGarcom = nomeGarcom;
    }
}
