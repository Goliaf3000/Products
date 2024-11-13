package com.mysclad.Products.SotedAndFilter;

import org.springframework.data.jpa.domain.Specification;
import com.mysclad.Products.model.Products;

public class ProductSpecification {

    public static Specification<Products> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(root.get("productName"), "%" + name + "%");
    }

    // Фильтрация по минимальной цене
    public static Specification<Products> hasPriceGreaterThanOrEqualTo(Integer minPrice) {
        return (root, query, criteriaBuilder) ->
                minPrice == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("productPrice"), minPrice);
    }

    // Фильтрация по максимальной цене
    public static Specification<Products> hasPriceLessThanOrEqualTo(Integer maxPrice) {
        return (root, query, criteriaBuilder) ->
                maxPrice == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("productPrice"), maxPrice);
    }

    // Фильтрация по наличию товара
    public static Specification<Products> hasStock(String stock) {
        return (root, query, criteriaBuilder) ->
                stock == null ? null : criteriaBuilder.equal(root.get("productStock"), stock);
    }
}
