package com.muazzam.sample.service;

import com.muazzam.sample.model.Product;

import java.util.Collection;

public interface ProductService {
    void add(Collection<Product> products);

    Collection<Product> get(String productType, Integer productId);

    void remove(Integer productId);


}