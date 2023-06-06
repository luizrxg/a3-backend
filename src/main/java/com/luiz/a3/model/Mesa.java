package com.luiz.a3.model;

import java.util.Optional;

public class Mesa {

    private final Long numero;
    private final SituacaoMesa situacao;
    private final Long capacidadeMaxima;

    private final Optional<Long> idGarcom;

    public Mesa(
        final Long numero,
        final SituacaoMesa situacao,
        final Long capacidadeMaxima,
        final Optional<Long> idGarcom
    ) {
        this.numero = numero;
        this.situacao = situacao;
        this.capacidadeMaxima = capacidadeMaxima;
        this.idGarcom = idGarcom;
    }

    public Long getNumero() { return numero; }

    public SituacaoMesa getSituacao() { return situacao; }

    public Long getCapacidadeMaxima() { return capacidadeMaxima; }

    public Optional<Long> getIdGarcom() { return idGarcom; }
}
