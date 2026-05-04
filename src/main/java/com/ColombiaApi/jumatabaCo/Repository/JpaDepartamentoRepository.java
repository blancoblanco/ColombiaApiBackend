package com.ColombiaApi.jumatabaCo.Repository;

import com.ColombiaApi.jumatabaCo.model.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaDepartamentoRepository  extends JpaRepository<Departamento,Integer> {
    List<Departamento> findByNombreContainingIgnoreCase(String nombre);




}
