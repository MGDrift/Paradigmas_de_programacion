package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Producto;

import java.util.List;

public interface ProductoService {
    public void createOrUpdateProduct(Producto emp);

    public List<Producto> getAllProducts();

    public void deleteProduct(String id);

    public Producto editProduct(String id);
}
