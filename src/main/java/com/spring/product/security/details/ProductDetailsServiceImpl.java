package com.spring.product.security.details;

import com.spring.product.models.Product;
import com.spring.product.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductDetailsServiceImpl implements UserDetailsService {

    private final ProductsRepository productsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Product product = productsRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new ProductDetailsImpl(product);
    }
}
