package com.ColombiaApi.jumatabaCo.Repository;

import com.ColombiaApi.jumatabaCo.model.AmenazaSismica;
import com.ColombiaApi.jumatabaCo.model.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaDepartamentoRepository  extends JpaRepository<Departamento,Integer> {
    List<Departamento> findByNombreContainingIgnoreCase(String nombre);




}
