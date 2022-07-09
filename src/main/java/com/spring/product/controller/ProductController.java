package com.spring.product.controller;

import com.spring.product.models.Product;
import com.spring.product.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/product")
    public String addProduct(@RequestParam("name") String name) {

        Product product = Product.builder()
                .name(name).build();
        productsRepository.save(product);

        return "redirect:/product_add.html";
    }
}
