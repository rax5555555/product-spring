package com.spring.product.services;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductForm form);

    List<Product> getAllProduct();

    void deleteProduct(Long productId);

    Product getProduct(Long productId);
}
