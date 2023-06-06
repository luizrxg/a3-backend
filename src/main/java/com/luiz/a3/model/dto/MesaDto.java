package com.luiz.a3.model.dto;

import com.luiz.a3.model.entity.Garcom;
import com.luiz.a3.model.entity.Mesa;
import com.luiz.a3.model.enums.SituacaoMesa;

import java.util.Optional;

public class MesaDto {

    private Long id;
    private Long numero;
    private String situacao;
    private Long capacidadeMaxima;
    private Long idGarcom;

    public static MesaDto converter(Mesa m) {
        var mesa = new MesaDto();
        mesa.setId(m.getId());
        mesa.setNumero(m.getNumero());
        mesa.setSituacao(m.getSituacao());
        mesa.setCapacidadeMaxima(m.getCapacidadeMaxima());
        mesa.setIdGarcom(m.getIdGarcom());
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
}
