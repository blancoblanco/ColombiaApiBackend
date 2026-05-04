package com.ColombiaApi.jumatabaCo.Repository;

import com.ColombiaApi.jumatabaCo.model.Microzonificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMicrozonificacionRepository extends JpaRepository<Microzonificacion,Integer > {
    List<Microzonificacion> findByMunicipio_IdMunicipio(Integer idMunicipio);
}
