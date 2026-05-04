package com.ColombiaApi.jumatabaCo.Repository;

import com.ColombiaApi.jumatabaCo.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaZonaRepository extends JpaRepository<Zona, Integer> {

}
