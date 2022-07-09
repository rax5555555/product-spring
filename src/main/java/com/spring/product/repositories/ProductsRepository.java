package com.spring.product.repositories;

import com.spring.product.models.Product;

import java.util.List;

/**
 * 15.11.2021
 * 20. Java IO
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface ProductsRepository {
    List<Product> findAll();

    List<Product> findAllByPrice(double price);

    void save(Product product);
}
