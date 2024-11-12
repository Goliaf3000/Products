package com.mysclad.Products.service;

import com.mysclad.Products.model.Products;
import java.util.List;

import com.mysclad.Products.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceClass implements ProductService {

    private final ProductsRepository productsRepository;

    public ProductServiceClass(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void create(Products product) {
        if (product.getProductPrice() == null || product.getProductPrice() < 0) {
            product.setProductPrice(0);
        }

        if (!product.getProductStock().toLowerCase().replaceAll(" ", "").equals("невналичии") && !product.getProductStock().toLowerCase().replaceAll(" ", "").equals("вналичии")) {
            product.setProductStock("не в наличии");
        }

        productsRepository.save(product);
    }
    @Override
    public List<Products> readAll() {
        return productsRepository.findAll();
    }

    public Products read(int id) {
        return productsRepository.getReferenceById(id);
    }

    public boolean update(Products product, int id) {
        if (productsRepository.existsById(id)){
            product.setId(id);
            productsRepository.save(product);
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(int id) {
        if (productsRepository.existsById(id)){
            productsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
