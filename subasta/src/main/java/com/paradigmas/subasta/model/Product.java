package com.paradigmas.subasta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String serialProduct;
    private String name;
    private Integer valor;
    private String descripcion;

    public String getSerialProduct() {
        return serialProduct;
    }

    public void setSerialProduct(String serialProduct) {
        this.serialProduct = serialProduct;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return valor;
    }

    public void setValue(Integer valor) {
        this.valor = valor;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }
}
