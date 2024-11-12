
package com.mysclad.Products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Table(name = "products")
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name")
    private String product_name;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_price")
    private Integer productPrice;
    @Column(name = "product_stock")
    private String productStock;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return this.product_name;
    }

    public void setProductName(String productName) {
        this.product_name = productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStock() {
        return this.productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }
}
