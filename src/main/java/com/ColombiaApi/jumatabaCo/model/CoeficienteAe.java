package com.ColombiaApi.jumatabaCo.model;

public enum CoeficienteAe {

    AE_002(0.02),
    AE_003(0.03),
    AE_004(0.04),
    AE_005(0.05),
    AE_006(0.06),
    AE_007(0.07),
    AE_008(0.08),
    AE_009(0.09),
    AE_010(0.10),
    AE_011(0.11),
    AE_012(0.12),
    AE_013(0.13),
    AE_014(0.14),
    AE_015(0.15),
    AE_016(0.16),
    AE_017(0.17),
    AE_018(0.18),
    AE_019(0.19),
    AE_020(0.20),
    AE_021(0.21),
    AE_022(0.22),
    AE_023(0.23),
    AE_024(0.24),
    AE_025(0.25),
    AE_026(0.26),
    AE_028(0.28),
    AE_031(0.31),
    AE_032(0.32),
    AE_036(0.36);

    private final double valor;

    CoeficienteAe(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
