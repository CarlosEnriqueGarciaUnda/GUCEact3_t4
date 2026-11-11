package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String paisOrigen;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("marca")
    private List<Auto> autos;

    // Constructor vacío obligatorio para Jackson y JPA
    public Marca() {
    }

    // Constructor con ID (útil para cuando solo se envía el ID en el JSON)
    public Marca(Long id) {
        this.id = id;
    }

    public Marca(String nombre, String paisOrigen) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
    }

    // Getters y Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getPaisOrigen() { 
        return paisOrigen; 
    }
    
    public void setPaisOrigen(String paisOrigen) { 
        this.paisOrigen = paisOrigen; 
    }

    public List<Auto> getAutos() { 
        return autos; 
    }
    
    public void setAutos(List<Auto> autos) { 
        this.autos = autos; 
    }
}