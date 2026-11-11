package com.example.demo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private Integer anio;
    private Double precio;

    // Relación Muchos a 1: Muchos Autos pertenecen a una Marca
    @ManyToOne
    @JoinColumn(name = "marca_id") // Clave foránea en la tabla autos
    @JsonIgnoreProperties("autos") // Previene ciclos infinitos al responder con JSON
    private Marca marca;

    public Auto() {}

    public Auto(String modelo, Integer anio, Double precio, Marca marca) {
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.marca = marca;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}