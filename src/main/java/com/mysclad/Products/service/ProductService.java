package com.mysclad.Products.service;

import com.mysclad.Products.model.Products;
import com.mysclad.Products.repository.ProductsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductService  {
    void create(Products product);

    Page<Products> findAll(Specification<Products> specification, Pageable pageable);

    Products read(int id);

    boolean update(Products product, int id);

    boolean delete(int id);
}
