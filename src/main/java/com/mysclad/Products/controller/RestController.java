package com.mysclad.Products.controller;

import com.mysclad.Products.SotedAndFilter.ProductSpecification;
import com.mysclad.Products.model.Products;
import com.mysclad.Products.service.ProductService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/products")
    public ResponseEntity<List<Products>> getProducts(@Valid ProductFilterRequest filterRequest) {
        Specification<Products> specification = Specification.where(ProductSpecification.hasName(filterRequest.getProductName()));

        if (filterRequest.getMinPrice() != null) {
            specification = specification.and(ProductSpecification.hasPriceGreaterThanOrEqualTo(filterRequest.getMinPrice()));
        }
        if (filterRequest.getMaxPrice() != null) {
            specification = specification.and(ProductSpecification.hasPriceLessThanOrEqualTo(filterRequest.getMaxPrice()));
        }

        if (filterRequest.getProductStock() != null) {
            specification = specification.and(ProductSpecification.hasStock(filterRequest.getProductStock()));
        }

        Sort sort = filterRequest.getSortDir().equalsIgnoreCase("asc") ?
                Sort.by(filterRequest.getSortBy()).ascending() :
                Sort.by(filterRequest.getSortBy()).descending();

        Pageable pageable = PageRequest.of(filterRequest.getPage(), filterRequest.getSize(), sort);

        List<Products> products = productService.findAll(specification, pageable).getContent();
        return ResponseEntity.ok(products);
    }

    @GetMapping({"/products/{id}"})
    public ResponseEntity<Products> read(@PathVariable(name = "id") int id) {
        Products products = this.productService.read(id);
        return products != null ? new ResponseEntity<>(products, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping({"/products/{id}"})
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Products products) {
        boolean update = this.productService.update(products, id);
        return update ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping({"/products/{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        boolean deleted = this.productService.delete(id);
        return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
