package com.spring.product.services;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;
import com.spring.product.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void addProduct(ProductForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .build();
        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProduct(Long productId) {
        productsRepository.delete(productId);
    }

    @Override
    public Product getProduct(Long productId) {
        return productsRepository.findById(productId);
    }
}
