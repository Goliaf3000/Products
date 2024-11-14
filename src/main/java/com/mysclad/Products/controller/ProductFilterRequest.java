package com.mysclad.Products.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductFilterRequest {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;

    @PositiveOrZero(message = "Минимальная цена должна быть положительным числом или нулем")
    private Integer minPrice;


    @PositiveOrZero(message = "Максимальная цена должна быть положительным числом или нулем")
    private Integer maxPrice;

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    private String productStock;

    @Pattern(regexp = "productName|productPrice", message = "Поле сортировки должно быть 'productName' или 'productPrice'")
    private String sortBy = "productName"; // значение по умолчанию

    @Pattern(regexp = "asc|desc", message = "Направление сортировки должно быть 'asc' или 'desc'")
    private String sortDir = "asc"; // значение по умолчанию

    @Min(value = 0, message = "Номер страницы должен быть больше или равен 0")
    private int page = 0;

    @Min(value = 1, message = "Размер страницы должен быть больше 0")
    private int size = 10;

    public @PositiveOrZero(message = "Минимальная цена должна быть положительным числом или нулем") Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(@PositiveOrZero(message = "Минимальная цена должна быть положительным числом или нулем") Integer minPrice) {
        this.minPrice = minPrice;
    }
    public @PositiveOrZero(message = "Максимальная цена должна быть положительным числом или нулем") Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(@PositiveOrZero(message = "Максимальная цена должна быть положительным числом или нулем") Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public @Pattern(regexp = "productName|productPrice", message = "Поле сортировки должно быть 'productName' или 'productPrice'") String getSortBy() {
        return sortBy;
    }

    public void setSortBy(@Pattern(regexp = "productName|productPrice", message = "Поле сортировки должно быть 'productName' или 'productPrice'") String sortBy) {
        this.sortBy = sortBy;
    }

    public @Pattern(regexp = "asc|desc", message = "Направление сортировки должно быть 'asc' или 'desc'") String getSortDir() {
        return sortDir;
    }

    public void setSortDir(@Pattern(regexp = "asc|desc", message = "Направление сортировки должно быть 'asc' или 'desc'") String sortDir) {
        this.sortDir = sortDir;
    }

    @Min(value = 0, message = "Номер страницы должен быть больше или равен 0")
    public int getPage() {
        return page;
    }

    public void setPage(@Min(value = 0, message = "Номер страницы должен быть больше или равен 0") int page) {
        this.page = page;
    }

    @Min(value = 1, message = "Размер страницы должен быть больше 0")
    public int getSize() {
        return size;
    }

    public void setSize(@Min(value = 1, message = "Размер страницы должен быть больше 0") int size) {
        this.size = size;
    }
}
