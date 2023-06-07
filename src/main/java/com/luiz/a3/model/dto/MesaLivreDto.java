package com.luiz.a3.model.dto;

import com.luiz.a3.model.entity.Mesa;

public class MesaLivreDto {

    private Long id;
    private Long numero;
    private String situacao;
    private Long capacidadeMaxima;
    private Long idGarcom;
    private String nomeGarcom;

    public static MesaLivreDto converter(
            Mesa m,
            String nome
    ) {
        var mesa = new MesaLivreDto();
        mesa.setId(m.getId());
        mesa.setNumero(m.getNumero());
        mesa.setSituacao(m.getSituacao());
        mesa.setCapacidadeMaxima(m.getCapacidadeMaxima());
        mesa.setIdGarcom(m.getIdGarcom());
        mesa.setNomeGarcom(nome);
        return mesa;
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

    public void setNomeGarcom(String nomeGarcom) { this.nomeGarcom = nomeGarcom; }

    public Long getId() {
        return id;
    }

    public Long getNumero() {
        return numero;
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

    public String getNomeGarcom() { return nomeGarcom; }
}
