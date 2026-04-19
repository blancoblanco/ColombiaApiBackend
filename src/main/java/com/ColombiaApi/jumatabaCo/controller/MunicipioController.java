package com.ColombiaApi.jumatabaCo.controller;

import com.ColombiaApi.jumatabaCo.Repository.JpaMunicipioRepository;

import com.ColombiaApi.jumatabaCo.exeption.ResourceNotFoundException;

import com.ColombiaApi.jumatabaCo.model.AmenazaSismica;
import com.ColombiaApi.jumatabaCo.model.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:5173")
@RestController
@RequestMapping("/apiCo/v1/municipios")
public class MunicipioController {

    @Autowired
    private JpaMunicipioRepository jpaMunicipioRepository;

    //lista todos los municipios
    @GetMapping
    public List<Municipio>  listarMunipios(){
        return  jpaMunicipioRepository.findAll();
    }

    //lista municipio por id
    @GetMapping("/{idMunicipio}")
    public ResponseEntity<Municipio> listarMunipioById(@PathVariable int idMunicipio){
        Municipio municipio= jpaMunicipioRepository.findById(idMunicipio).orElseThrow(()->new ResourceNotFoundException("el municipio con ese id no existe"));
        return ResponseEntity.ok(municipio);
    }
    //lista municipio por nombre
    @GetMapping("/nombre/{nombre}")
    public  List<Municipio> listarByNombre(@PathVariable String nombre){
        return jpaMunicipioRepository.findByNombreContainingIgnoreCase(nombre);
    }
    //lista municipio por codigo dane
    @GetMapping("/dane/{codigoDane}")
    public ResponseEntity<Municipio> listarCodigoDane(@PathVariable String codigoDane){
        Municipio municipio=jpaMunicipioRepository.findByCodigoDane(codigoDane).orElseThrow(()->new ResourceNotFoundException("el municipio con ese codigo dane no existe"));
        return ResponseEntity.ok(municipio);
    }
    //lista municipio por amenaza sismica
    @GetMapping("/amenaza/{amenazaSismica}")
    public  List<Municipio> listarAmenaza(@PathVariable AmenazaSismica amenazaSismica){
        return  jpaMunicipioRepository.findByAmenazaSismica(amenazaSismica);
    }


    @PostMapping
    public Municipio saveMunicipio(@RequestBody Municipio municipio){
        return jpaMunicipioRepository.save(municipio);
    }

    @DeleteMapping("/{idMunicipio}")
    public ResponseEntity<Map<String,Boolean>> deleteMunicipio(@PathVariable int idMunicipio){
        Municipio municipio =jpaMunicipioRepository.findById(idMunicipio).orElseThrow(()->new ResourceNotFoundException("el municipio con ese id no existe"));
        jpaMunicipioRepository.delete(municipio);
        Map<String,Boolean>response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{idMunicipio}")
    public  ResponseEntity<Municipio> updatableMunicipio(@PathVariable Integer idMunicipio, @RequestBody Municipio municipioRequest){
        Municipio municipio =jpaMunicipioRepository.findById(idMunicipio).orElseThrow(()->new ResourceNotFoundException("el municipio con ese id no existe"));
        municipio.setNombre(municipioRequest.getNombre());
        municipio.setCodigoDane(municipioRequest.getCodigoDane());
        municipio.setAmenazaSismica(municipioRequest.getAmenazaSismica());
        municipio.setAa(municipioRequest.getAa());
        municipio.setAv(municipioRequest.getAv());
        municipio.setAe(municipioRequest.getAe());
        municipio.setAd(municipioRequest.getAd());
        municipio.setDepartamento(municipioRequest.getDepartamento());
        Municipio municipioActualizado = jpaMunicipioRepository.save(municipio);
        return  ResponseEntity.ok(municipioActualizado);
    }



}
