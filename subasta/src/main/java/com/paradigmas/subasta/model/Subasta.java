package com.paradigmas.subasta.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Subasta {
    @Id
    private String id;
    private Date fechaInit;
    private Date fechaFinal;
    private Producto producto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return fechaInit;
    }

    public void setInitialDate(Date fechaInit) {
        this.fechaInit = fechaInit;
    }

    public Date getFinalDate() {
        return fechaFinal;
    }

    public void setFinalDate(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Producto getProduct() {
        return producto;
    }

    public void setProduct(Producto producto) {
        this.producto = producto;
    }
}
