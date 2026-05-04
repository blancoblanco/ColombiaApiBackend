package com.ColombiaApi.jumatabaCo.controller;


import com.ColombiaApi.jumatabaCo.Repository.JpaMicrozonificacionRepository;
import com.ColombiaApi.jumatabaCo.Repository.JpaZonaRepository;
import com.ColombiaApi.jumatabaCo.exeption.ResourceNotFoundException;
import com.ColombiaApi.jumatabaCo.model.Microzonificacion;
import com.ColombiaApi.jumatabaCo.model.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "${ALLOWED_ORIGINS:http://localhost:5173}")
@RestController
@RequestMapping("/apiCo/v1/zona")
public class ZonaController {



    @Autowired
    private JpaZonaRepository jpaZonaRepository;

    @GetMapping
    public List<Zona> listarZona(){
        return  jpaZonaRepository.findAll();
    }

    @GetMapping("{idZona}")
    public ResponseEntity<Zona> ListarById(@PathVariable int idZona){
        Zona zona= jpaZonaRepository.findById(idZona).orElseThrow(()->new ResourceNotFoundException("la zona con ese id no existe"));
        return ResponseEntity.ok(zona);
    }


    @PostMapping
    public Zona save(@RequestBody Zona zona ){
        return  jpaZonaRepository.save(zona);
    }

    @DeleteMapping("/{idZona}")
    public ResponseEntity<Map<String,Boolean>> eliminarMicrozonificacion(@PathVariable int idZona){
        Zona zona= jpaZonaRepository.findById(idZona).orElseThrow(()->new ResourceNotFoundException("la zona con ese id no existe"));
        jpaZonaRepository.delete(zona);
        HashMap<String,Boolean> response = new HashMap<>();
        response.put("eliminado", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }



        @PutMapping("/{idZona}")
    public ResponseEntity<Zona> actualizarZona(@PathVariable int idZona,@RequestBody Zona zonaRequest ){
        Zona zona= jpaZonaRepository.findById(idZona).orElseThrow(()->new ResourceNotFoundException("la zona con ese id no existe"));
        zona.setZonaRespuestaSismica(zonaRequest.getZonaRespuestaSismica());
        zona.setFa(zonaRequest.getFa());
        zona.setFv(zonaRequest.getFv());
        zona.setTc(zonaRequest.getTc());
        zona.setTl(zonaRequest.getTl());
        zona.setA0(zonaRequest.getA0());
        zona.setT0(zonaRequest.getT0());
        Zona zonaActualizada=jpaZonaRepository.save(zona);
        return ResponseEntity.ok(zonaActualizada);
    }

}

