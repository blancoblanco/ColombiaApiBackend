package com.ColombiaApi.jumatabaCo.model;

public enum CoeficienteAv {

    AV_005(0.05),
    AV_010(0.10),
    AV_015(0.15),
    AV_020(0.20),
    AV_025(0.25),
    AV_030(0.30),
    AV_035(0.35),
    AV_040(0.40);

    private final double valor;

    CoeficienteAv(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

}
