# Actividad 3 - CRUD con Spring Boot, JPA y MySQL en VPS

Este proyecto implementa una API RESTful utilizando Spring Boot y Spring Data JPA para gestionar **Marcas** y **Autos**. Se encuentra desplegado en un servidor VPS de Azure.

## Entidades y Relación
- **Marca:** Entidad principal.
- **Auto:** Entidad secundaria.
- **Relación:** Un Auto pertenece a una Marca (`@ManyToOne`), y una Marca puede tener muchos Autos (`@OneToMany`).

## Evidencias de Operaciones CRUD en Producción (VPS)

### 1. Crear (POST)
Se registra una nueva Marca y posteriormente un Auto asociado a dicha Marca.
<img width="1366" height="766" alt="image" src="https://github.com/user-attachments/assets/5ff44ba5-5a4c-433b-985b-657f523d919c" />


### 2. Leer (GET)
Consulta de la lista de Autos donde se refleja correctamente la relación (se ve la información de la Marca, no solo el ID).
<img width="1366" height="766" alt="image" src="https://github.com/user-attachments/assets/5dbb7942-a81d-456f-a3ff-9618034ab9fc" />


### 3. Actualizar (PUT)
Actualización del precio o modelo de un Auto existente.
<img width="1366" height="766" alt="image" src="https://github.com/user-attachments/assets/bec6a65a-5b68-4baf-a9e4-d87432a4811a" />


### 4. Eliminar (DELETE)
Eliminación de un registro mediante su ID.
<img width="1366" height="766" alt="image" src="https://github.com/user-attachments/assets/cd4e76ef-fce6-4ec0-8c1e-5e2898fe3c65" />

