package com.example.demo.controller;

import com.example.demo.entity.Auto;
import com.example.demo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autos")
public class AutoController {

    @Autowired
    private AutoService autoService;

    // 1. Obtener todos los autos (incluye la información de la marca asociada)
    @GetMapping
    public List<Auto> listarTodos() {
        return autoService.obtenerTodos();
    }

    // 2. Obtener auto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Auto> obtenerPorId(@PathVariable Long id) {
        return autoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Crear auto
    @PostMapping
    public Auto crear(@RequestBody Auto auto) {
        return autoService.guardar(auto);
    }

    // 4. Actualizar auto
    @PutMapping("/{id}")
    public ResponseEntity<Auto> actualizar(@PathVariable Long id, @RequestBody Auto autoDetalles) {
        return autoService.obtenerPorId(id)
                .map(auto -> {
                    auto.setModelo(autoDetalles.getModelo());
                    auto.setAnio(autoDetalles.getAnio());
                    auto.setPrecio(autoDetalles.getPrecio());
                    if (autoDetalles.getMarca() != null) {
                        auto.setMarca(autoDetalles.getMarca());
                    }
                    return ResponseEntity.ok(autoService.guardar(auto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Eliminar auto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (autoService.obtenerPorId(id).isPresent()) {
            autoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}