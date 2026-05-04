package com.ColombiaApi.jumatabaCo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "zona")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idZona;

    private String zonaRespuestaSismica;
    private double fa;
    private double fv;
    private double tc;
    private double tl;
    private double A0;

    @ManyToOne
    @JoinColumn(name = "id_microzonificacion")
    private Microzonificacion microzonificacion;

}
