package com.mysclad.Products.service;

import com.mysclad.Products.model.Products;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.mysclad.Products.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceClass implements ProductService,ProductsRepository {

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
    public Optional<Products> findOne(Specification<Products> spec) {
        return Optional.empty();
    }

    @Override
    public List<Products> findAll(Specification<Products> spec) {
        return List.of();
    }

    @Override
    public Page<Products> findAll(Specification<Products> specification, Pageable pageable) {
        return productsRepository.findAll(specification, pageable);
    }
    @Override
    public List<Products> findAll(Specification<Products> spec, Sort sort) {
        return List.of();
    }

    @Override
    public long count(Specification<Products> spec) {
        return 0;
    }

    @Override
    public boolean exists(Specification<Products> spec) {
        return false;
    }

    @Override
    public long delete(Specification<Products> spec) {
        return 0;
    }

    @Override
    public <S extends Products, R> R findBy(Specification<Products> spec, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    public Products read(int id) {
        return productsRepository.getReferenceById(id);
    }

    @Transactional
    public boolean update(Products newProductData, int id) {
        Optional<Products> existingProductOptional = productsRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Products existingProduct = existingProductOptional.get();

            existingProduct.setProductName(newProductData.getProductName());
            existingProduct.setProductDescription(newProductData.getProductDescription());
            existingProduct.setProductPrice(newProductData.getProductPrice());
            existingProduct.setProductStock(newProductData.getProductStock());

            productsRepository.saveAndFlush(existingProduct);
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

    @Override
    public void flush() {

    }

    @Override
    public <S extends Products> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Products> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Products> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Products getOne(Integer integer) {
        return null;
    }

    @Override
    public Products getById(Integer integer) {
        return null;
    }

    @Override
    public Products getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Products> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Products> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Products> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Products> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Products> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Products> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Products, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Products> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Products> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Products> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Products> findAll() {
        return List.of();
    }

    @Override
    public List<Products> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Products entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Products> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Products> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return null;
    }
}
