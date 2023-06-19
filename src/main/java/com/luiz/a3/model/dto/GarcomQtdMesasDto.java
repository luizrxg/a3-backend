package com.luiz.a3.model.dto;

public class GarcomQtdMesasDto {

    private GarcomDto garcom;
    private int qtd;

    public static GarcomQtdMesasDto converter(
        final GarcomDto g,
        final int qtd
    ) {
        var garcom = new GarcomQtdMesasDto();
        garcom.setGarcom(g);
        garcom.setQtd(qtd);
        return garcom;
    }

    public GarcomDto getGarcom() {
        return garcom;
    }

    public void setGarcom(GarcomDto garcom) {
        this.garcom = garcom;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
