package com.ColombiaApi.jumatabaCo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMunicipio;

    private String nombre;

    @Column(unique = true)
    private String codigoDane;

    @Enumerated(EnumType.STRING)
    private AmenazaSismica amenazaSismica;

    @Enumerated(EnumType.STRING)
    private CoeficienteAa aa;

    @Enumerated(EnumType.STRING)
    private CoeficienteAv av;

    @Enumerated(EnumType.STRING)
    private CoeficienteAe ae;

    @Enumerated(EnumType.STRING)
    private CoeficienteAd ad;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}