package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getById(String id);
    Product createOrUpdateProduct(Product emp);
    boolean changeValue(String serialProduct, Integer value);

    void deleteProduct(String id);
}
