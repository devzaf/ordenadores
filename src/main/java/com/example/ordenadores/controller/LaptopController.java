package com.example.ordenadores.controller;

import com.example.ordenadores.entity.Ordenador;
import com.example.ordenadores.repository.OrdenadorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;

    OrdenadorRepository ordenadorRepository;

    public LaptopController(OrdenadorRepository ordenadorRepository) {
        this.ordenadorRepository = ordenadorRepository;
    }

    @GetMapping("/api/ordenadores")
    public List<Ordenador> findAll() {
        System.out.println("El saludo desde properties es : "+ message);
        return ordenadorRepository.findAll();
    }

    @GetMapping("/api/ordenadores/{id}")
    public ResponseEntity<Ordenador> findOneById(@PathVariable Long id) {
        Optional<Ordenador> ordenadorOpt = ordenadorRepository.findById(id);
        if (ordenadorOpt.isPresent())
            return ResponseEntity.ok(ordenadorOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/ordenadores")
    public ResponseEntity<Ordenador> create(@RequestBody Ordenador ordenador) {
        if (ordenador.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Ordenador result = ordenadorRepository.save(ordenador);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/ordenadores")
    public ResponseEntity<Ordenador> update(@RequestBody Ordenador ordenador) {
        if (ordenador.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (!ordenadorRepository.existsById(ordenador.getId())) {
            return ResponseEntity.notFound().build();
        }

        Ordenador result = ordenadorRepository.save(ordenador);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/ordenadores/{id}")
    public ResponseEntity<Ordenador> delete(@PathVariable Long id) {
        if (!ordenadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ordenadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
