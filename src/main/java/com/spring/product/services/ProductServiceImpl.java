package com.spring.product.services;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;
import com.spring.product.models.Prop;
import com.spring.product.repositories.ProductsRepository;
import com.spring.product.repositories.PropRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final PropRepository propRepository;

//    @Autowired
//    public ProductServiceImpl(ProductsRepository productsRepository, PropRepository propRepository) {
//        this.productsRepository = productsRepository;
//        this.propRepository = propRepository;
//    }

    @Override
    public void addProduct(ProductForm form) {
        Product product = Product.builder()
                .name(form.getName())
                .cost(1)
                .quantity(1)
                .build();
        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productsRepository.deleteById(productId);
    }

    @Override
    public Product getProduct(Integer productId) {
        return productsRepository.getById(productId);
    }

    @Override
    public List<Prop> getPropByUser(Integer productId) {
        return propRepository.findAllByOwner_Id(productId);
    }

    @Override
    public List<Prop> getPropWithoutOwner() {
        return propRepository.findAllByOwnerIsNull();
    }

    @Override
    public void addPropToProduct(Integer productId, Integer propId) {
        Product product = productsRepository.getById(productId);
        Prop prop = propRepository.getById(propId);
        prop.setOwner(product);
        propRepository.save(prop);
    }
}
