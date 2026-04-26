package com.ColombiaApi.jumatabaCo.controller;

import com.ColombiaApi.jumatabaCo.Repository.JpaDepartamentoRepository;
import com.ColombiaApi.jumatabaCo.exeption.ResourceNotFoundException;
import com.ColombiaApi.jumatabaCo.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "${ALLOWED_ORIGINS:http://localhost:5173}")
@RestController
@RequestMapping("/apiCo/v1/departamentos")
public class DepartamentoController {

    @Autowired
    private JpaDepartamentoRepository jpaDepartamentoRepository;

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return jpaDepartamentoRepository.findAll();
    }

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<Departamento> listarDepartamentoById(@PathVariable int idDepartamento) {
        Departamento departamento = jpaDepartamentoRepository.findById(idDepartamento).orElseThrow(() -> new ResourceNotFoundException("el departamento con ese id no existe"));
        return ResponseEntity.ok(departamento);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Departamento> listarDepartamentoByNombre(@PathVariable String nombre) {
        return jpaDepartamentoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @PostMapping
    public Departamento saveDepartamento(@RequestBody Departamento departamento) {
        return jpaDepartamentoRepository.save(departamento);
    }

    @DeleteMapping("/{idDepartamento}")
    public ResponseEntity<Map<String, Boolean>> deleteDepartamento(@PathVariable int idDepartamento) {
        Departamento departamento = jpaDepartamentoRepository.findById(idDepartamento).orElseThrow(() -> new ResourceNotFoundException("el departamento con ese id no existe"));
        jpaDepartamentoRepository.delete(departamento);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idDepartamento}")
    public ResponseEntity<Departamento> updatableDepartamento(@PathVariable Integer idDepartamento, @RequestBody Departamento departamentoRequest) {
        Departamento departamento = jpaDepartamentoRepository.findById(idDepartamento).orElseThrow(() -> new ResourceNotFoundException("el departamento con ese id no existe"));
        departamento.setNombre(departamentoRequest.getNombre());
        Departamento departamentoActualizado = jpaDepartamentoRepository.save(departamento);
        return ResponseEntity.ok(departamentoActualizado);
    }
}
