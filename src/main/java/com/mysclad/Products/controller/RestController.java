package com.mysclad.Products.controller;

import com.mysclad.Products.SotedAndFilter.ProductSpecification;
import com.mysclad.Products.model.Products;
import com.mysclad.Products.service.ProductService;
import java.util.List;
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
    public List<Products> getProducts(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) String productStock,
            @RequestParam(required = false, defaultValue = "productName") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortDir,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        Specification<Products> specification = Specification.where(ProductSpecification.hasName(productName));

        // Добавляем фильтрацию по цене, если параметры minPrice или maxPrice указаны
        if (minPrice != null) {
            specification = specification.and(ProductSpecification.hasPriceGreaterThanOrEqualTo(minPrice));
        }
        if (maxPrice != null) {
            specification = specification.and(ProductSpecification.hasPriceLessThanOrEqualTo(maxPrice));
        }

        // Добавляем фильтрацию по наличию товара
        if (productStock != null) {
            specification = specification.and(ProductSpecification.hasStock(productStock));
        }

        // Настройка сортировки
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        // Получаем результаты с применением пагинации и сортировки
        return productService.findAll(specification, pageable).getContent();
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
