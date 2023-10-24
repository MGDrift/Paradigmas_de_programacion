package com.paradigmas.subasta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Persona {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String tipo;
    private Integer productosAdquiridos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return nombre;
    }

    public void setFirstName(String nombre) {
        this.nombre = nombre;
    }

    public String getLastName() {
        return apellido;
    }

    public void setLastName(String apellido) {
        this.apellido = apellido;
    }

    public String getType() {
        return tipo;
    }

    public void setType(String tipo) {
        this.tipo = tipo;
    }

    public int getPurchaseProducts() {
        return productosAdquiridos;
    }

    public void setPurchaseProducts(int productosAdquiridos) {
        this.productosAdquiridos = productosAdquiridos;
    }
}
