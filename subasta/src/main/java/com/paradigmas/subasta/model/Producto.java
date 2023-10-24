package com.paradigmas.subasta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Producto {
    @Id
    private String id;
    private String nombre;
    private Integer precio;
    private String descripcion;

    public String getId() {
        return id;
    }

    public void setId(String idProducto) {
        this.id = idProducto;
    }

    public String getFirstName() {
        return nombre;
    }

    public void setFirstName(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrice() {
        return precio;
    }

    public void setPrice(int precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
}
