package com.mysclad.Products.controller;

import com.mysclad.Products.model.Products;
import com.mysclad.Products.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final ProductService productService;

    @Autowired
    public RestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping({"/products"})
    public ResponseEntity<?> create(@RequestBody Products products) {
        if (products.getProductName().length() < 255 && !products.getProductName().isEmpty() && products.getProductDescription().length() < 4096) {
            this.productService.create(products);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping({"/products"})
    public ResponseEntity<List<Products>> readAll() {
        List<Products> products = this.productService.readAll();
        return products != null && !products.isEmpty() ? new ResponseEntity(products, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping({"/products/{id}"})
    public ResponseEntity<Products> read(@PathVariable(name = "id") int id) {
        Products products = this.productService.read(id);
        return products != null ? new ResponseEntity(products, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/products/{id}"})
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Products products) {
        boolean update = this.productService.update(products, id);
        return update ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping({"/products/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = this.productService.delete(id);
        return deleted ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
