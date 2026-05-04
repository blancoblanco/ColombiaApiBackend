package com.ColombiaApi.jumatabaCo.Repository;

import com.ColombiaApi.jumatabaCo.model.coeficientes.AmenazaSismica;
import com.ColombiaApi.jumatabaCo.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;

@Repository
public interface JpaMunicipioRepository extends JpaRepository<Municipio,Integer> {
   List<Municipio>  findByNombreContainingIgnoreCase(String nombre);

   Optional<Municipio> findByCodigoDane(String codigoDane);

   List<Municipio> findByAmenazaSismica(AmenazaSismica amenazaSismica);
}
