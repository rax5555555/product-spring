package com.spring.product.services;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductForm form);

    List<Product> getAllProduct();

    void deleteProduct(Long productId);

    Product getProduct(Long productId);
}
