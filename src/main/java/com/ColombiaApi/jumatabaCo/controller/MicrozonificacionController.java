package com.ColombiaApi.jumatabaCo.controller;


import com.ColombiaApi.jumatabaCo.Repository.JpaMicrozonificacionRepository;
import com.ColombiaApi.jumatabaCo.exeption.ResourceNotFoundException;
import com.ColombiaApi.jumatabaCo.model.Microzonificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${ALLOWED_ORIGINS:http://localhost:5173}")
@RestController
@RequestMapping("/apiCo/v1/Microzonificacion")
public class MicrozonificacionController {

    @Autowired
    private JpaMicrozonificacionRepository jpaMicrozonificacionRepository;

    @GetMapping
    public List<Microzonificacion> listarMicrozonificaciones(){
        return  jpaMicrozonificacionRepository.findAll();

    }
    @GetMapping("{idMicrozonificacion}")
    public ResponseEntity<Microzonificacion> ListarById(@PathVariable int idMicrozonificacion){
        Microzonificacion microzonificacion= jpaMicrozonificacionRepository.findById(idMicrozonificacion).orElseThrow(()->new ResourceNotFoundException("la microzonificacion  con ese id no existe"));
                return ResponseEntity.ok(microzonificacion);
    }

    @GetMapping("/{idMunicipio}")
    public List<Microzonificacion> listarMicrozonificacionByIdMunicipio(@PathVariable int idMunicipio ){
        return  jpaMicrozonificacionRepository.findByMunicipio_IdMunicipio(idMunicipio);
    }

    @PostMapping
    public Microzonificacion save(@RequestBody Microzonificacion microzonificacion ){
        return  jpaMicrozonificacionRepository.save(microzonificacion);
    }

    @DeleteMapping("/{idMicrozonificacion}")
    public ResponseEntity<Map<String,Boolean>> eliminarMicrozonificacion(@PathVariable int idMicrozonificacion){
        Microzonificacion microzonificacion= jpaMicrozonificacionRepository.findById(idMicrozonificacion).orElseThrow(()->new ResourceNotFoundException("la microzonificacion  con ese id no existe"));
        jpaMicrozonificacionRepository.delete(microzonificacion);
        HashMap<String,Boolean>response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }



    @PutMapping("/{idMicrozonificacion}")
    public ResponseEntity<Microzonificacion> actualizarMicrozonificacion(@PathVariable int idMicrozonificacion,@RequestBody Microzonificacion microzonificacionRequest){
        Microzonificacion microzonificacion= jpaMicrozonificacionRepository.findById(idMicrozonificacion).orElseThrow(()->new ResourceNotFoundException("la microzonificacion  con ese id no existe"));
        microzonificacion.setNombre(microzonificacionRequest.getNombre());
        microzonificacion.setZonas(microzonificacionRequest.getZonas());
        Microzonificacion microActualizada=jpaMicrozonificacionRepository.save(microzonificacion);
        return ResponseEntity.ok(microActualizada);
    }


}
