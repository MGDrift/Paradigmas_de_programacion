package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Product;
import com.paradigmas.subasta.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/list")
	public ResponseEntity<List<Product>> getAllAuction() {
		var products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/change-value")
	public ResponseEntity changeValue(@RequestParam("serialProduct") String serialProduct,
										 @RequestParam("value") Integer value) {
		try {
			var wasChanged = productService.changeValue(serialProduct, value);
			if (wasChanged) {
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (RuntimeException rte) {
			System.err.println(rte.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<Product> getById(@RequestParam("id") String id) {
		var products = productService.getById(id);
		return ResponseEntity.ok(products);
	}

	@PostMapping
	public ResponseEntity<Product> createAuction(@RequestBody Product product) {
		var productSaved = productService.createOrUpdateProduct(product);
		return ResponseEntity.ok(productSaved);
	}

	@DeleteMapping
	public ResponseEntity deleteAuction(@RequestParam("id") String id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<Product> updateAuction(@RequestBody Product product) {
		var productSaved = productService.createOrUpdateProduct(product);
		return ResponseEntity.ok(productSaved);
	}

}