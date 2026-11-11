package com.example.demo.service;

import com.example.demo.entity.Auto;
import com.example.demo.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> obtenerTodos() {
        return autoRepository.findAll();
    }

    public Optional<Auto> obtenerPorId(Long id) {
        return autoRepository.findById(id);
    }

    public Auto guardar(Auto auto) {
        return autoRepository.save(auto);
    }

    public void eliminar(Long id) {
        autoRepository.deleteById(id);
    }
}