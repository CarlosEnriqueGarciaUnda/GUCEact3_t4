package com.example.demo.controller;

import com.example.demo.entity.Marca;
import com.example.demo.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // 1. Obtener todas las marcas
    @GetMapping
    public List<Marca> listarTodas() {
        return marcaService.obtenerTodas();
    }

    // 2. Obtener marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Marca> obtenerPorId(@PathVariable Long id) {
        return marcaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Crear marca
    @PostMapping
    public Marca crear(@RequestBody Marca marca) {
        return marcaService.guardar(marca);
    }

    // 4. Actualizar marca
    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizar(@PathVariable Long id, @RequestBody Marca marcaDetalles) {
        return marcaService.obtenerPorId(id)
                .map(marca -> {
                    marca.setNombre(marcaDetalles.getNombre());
                    marca.setPaisOrigen(marcaDetalles.getPaisOrigen());
                    return ResponseEntity.ok(marcaService.guardar(marca));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Eliminar marca
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (marcaService.obtenerPorId(id).isPresent()) {
            marcaService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}