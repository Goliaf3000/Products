
package com.mysclad.Products.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
@Table(name = "products")
@Entity

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "productname")
    private String productName;
    @Column(name = "productdescription")
    private String productDescription;
    @Column(name = "productprice")
    private Integer productPrice;
    @Column(name = "productstock")
    private String productStock;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
