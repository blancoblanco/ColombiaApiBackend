package com.ColombiaApi.jumatabaCo.model;

import com.ColombiaApi.jumatabaCo.model.coeficientes.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private double aa;

    private double av;

    private double ae;

    private double ad;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;


    @OneToMany(mappedBy = "municipio")
    private List<Microzonificacion> microzonificaciones;
}