package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Product;
import com.paradigmas.subasta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicelmpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(String id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Product createOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean changeValue(String serialProduct, Integer value) {
        var productOpt = productRepository.findById(serialProduct);
        if (productOpt.isEmpty()) {
            throw new RuntimeException(String.format("El producto con el serialProduct %s no existe.", serialProduct));
        } else {
            var product = productOpt.get();
            if (product.getValue() < value) {
                product.setValue(value);
                productRepository.save(product);
                return true;
            } else {
                return false;
            }
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
