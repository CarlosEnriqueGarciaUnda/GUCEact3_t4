package com.example.demo.service;

import com.example.demo.entity.Marca;
import com.example.demo.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> obtenerTodas() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> obtenerPorId(Long id) {
        return marcaRepository.findById(id);
    }

    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    public void eliminar(Long id) {
        marcaRepository.deleteById(id);
    }
}