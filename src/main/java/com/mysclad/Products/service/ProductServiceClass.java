package com.mysclad.Products.service;

import com.mysclad.Products.model.Products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceClass implements ProductService {
    private static final Map<Integer, Products> PRODUCTS_MAP = new HashMap();
    private static final AtomicInteger ID_PRODUCT = new AtomicInteger();

    public ProductServiceClass() {
    }

    public void create(Products product) {
        int id = ID_PRODUCT.incrementAndGet();
        if (product.getProductPrice() == null || product.getProductPrice() < 0) {
            product.setProductPrice(0);
        }

        if (!product.getProductStock().toLowerCase().replaceAll(" ", "").equals("невналичии") && !product.getProductStock().toLowerCase().replaceAll(" ", "").equals("вналичии")) {
            product.setProductStock("не в наличии");
        }

        product.setId(id);
        PRODUCTS_MAP.put(id, product);
    }

    public List<Products> readAll() {
        return new ArrayList(PRODUCTS_MAP.values());
    }

    public Products read(int id) {
        return (Products)PRODUCTS_MAP.get(id);
    }

    public boolean update(Products product, int id) {
        if (PRODUCTS_MAP.containsKey(id)) {
            product.setId(id);
            PRODUCTS_MAP.put(id, product);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) {
        return PRODUCTS_MAP.remove(id) != null;
    }
}
