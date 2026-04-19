package com.ColombiaApi.jumatabaCo.model;

public enum CoeficienteAa {

    A_005(0.05),
    A_010(0.10),
    A_015(0.15),
    A_020(0.20),
    A_025(0.25),
    A_030(0.30),
    A_035(0.35),
    A_040(0.40),
    A_045(0.45),
    A_050(0.50);

    private final double valor;

    CoeficienteAa(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
