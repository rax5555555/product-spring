package com.spring.product.services;

import com.spring.product.forms.SignUpForm;
import com.spring.product.models.Product;
import com.spring.product.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final ProductsRepository productsRepository;
    @Override
    public void signUpProduct(SignUpForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .email(form.getEmail())
                .role(Product.Role.USER)
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
        productsRepository.save(product);
    }
}
