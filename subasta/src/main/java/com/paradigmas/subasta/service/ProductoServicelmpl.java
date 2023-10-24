package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Producto;
import com.paradigmas.subasta.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServicelmpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public void createOrUpdateProduct(Producto producto) {
        productoRepository.save(producto);
    }

    public List<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    public void deleteProduct(String id) {
        productoRepository.deleteById(id);
    }

    public Producto editProduct(String id) {
        return productoRepository.findById(id).orElse(new Producto());
    }
}
