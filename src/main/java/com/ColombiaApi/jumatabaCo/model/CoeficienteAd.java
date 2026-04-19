package com.ColombiaApi.jumatabaCo.model;

public enum CoeficienteAd {

    AD_002(0.02),
    AD_003(0.03),
    AD_004(0.04),
    AD_005(0.05),
    AD_006(0.06),
    AD_007(0.07),
    AD_008(0.08),
    AD_009(0.09),
    AD_010(0.10),
    AD_011(0.11),
    AD_012(0.12),
    AD_013(0.13),
    AD_014(0.14);


    private final double valor;

    CoeficienteAd(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
