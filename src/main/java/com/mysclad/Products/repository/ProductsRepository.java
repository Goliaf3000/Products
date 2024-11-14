package com.mysclad.Products.repository;

import com.mysclad.Products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {
}
