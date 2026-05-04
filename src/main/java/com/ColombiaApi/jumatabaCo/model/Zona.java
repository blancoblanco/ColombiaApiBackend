package com.ColombiaApi.jumatabaCo.model;

import com.ColombiaApi.jumatabaCo.model.coeficientes.ZonaRespuestaSismica;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idZona;

    @Enumerated(EnumType.STRING)
    private ZonaRespuestaSismica zonaRespuestaSismica;
    private double fa;
    private double fv;
    private double tc;
    private double tl;
    private double a0;
    private Double t0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_microzonificacion")
    private Microzonificacion microzonificacion;

}
