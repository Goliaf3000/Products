package com.mysclad.Products.service;

import com.mysclad.Products.model.Products;
import java.util.List;

public interface ProductService {
    void create(Products product);

    List<Products> readAll();

    Products read(int id);

    boolean update(Products product, int id);

    boolean delete(int id);
}
