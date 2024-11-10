
package com.mysclad.Products.model;

public class Products {
    private Integer id;
    private String productName;
    private String productDescription;
    private Integer productPrice;
    private String productStock;

    public Products() {
    }

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
