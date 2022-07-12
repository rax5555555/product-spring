package com.spring.product.repositories;

import com.spring.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByEmail(String email);
}
