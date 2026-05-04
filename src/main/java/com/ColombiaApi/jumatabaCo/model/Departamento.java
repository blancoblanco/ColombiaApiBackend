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
@Table(name = "departamento")
@JsonIgnoreProperties({"municipios", "hibernateLazyInitializer"})
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipios;
}