package com.ColombiaApi.jumatabaCo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "microzonificacion")
@JsonIgnoreProperties("zonas")
public class Microzonificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMicrozonificacion;

    private String nombre;

    @OneToMany(mappedBy = "microzonificacion")
    private List<Zona> zonas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio", nullable = true)
    private Municipio municipio;


}
