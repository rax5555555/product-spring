package com.spring.product.security.details;

import com.spring.product.models.Product;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class ProductDetailsImpl implements UserDetails {

    private final Product product;

    public ProductDetailsImpl(Product product) {
        this.product = product;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = product.getRole().toString();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return product.getHashPassword();
    }

    @Override
    public String getUsername() {
        return product.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
