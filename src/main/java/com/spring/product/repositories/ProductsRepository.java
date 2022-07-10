package com.spring.product.repositories;

import com.spring.product.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Rakhmatullin Timur
 * @version v1.0
 */

@Repository
public interface ProductsRepository {
    List<Product> findAll();

    List<Product> findAllByPrice(double price);

    void save(Product product);

    void delete(Long productId);

    Product findById(Long productId);
}
