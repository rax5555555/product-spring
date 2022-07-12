package com.spring.product.services;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;
import com.spring.product.models.Prop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductForm form);

    List<Product> getAllProduct();

    void deleteProduct(Integer productId);

    Product getProduct(Integer productId);

    List<Prop> getPropByUser(Integer productId);

    List<Prop> getPropWithoutOwner();

    void addPropToProduct(Integer productId, Integer propId);

    void update(Integer productId, ProductForm productForm);
}
