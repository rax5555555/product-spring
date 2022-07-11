package com.spring.product.controller;

import com.spring.product.forms.ProductForm;
import com.spring.product.models.Product;
import com.spring.product.models.Prop;
import com.spring.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String getProductPage(Model model) {
        List<Product> product = productService.getAllProduct();
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/product/{product-id}")
    public String getUserPage(Model model, @PathVariable("product-id") Integer productId) {
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);
        return "product_unit";
    }

    @PostMapping("/product")
    public String addProduct(ProductForm form) {
        productService.addProduct(form);
        //System.out.println(productsRepository.findAll());
        return "redirect:/product";
    }

    @PostMapping("/product/{product-id}/delete")
    public String deleteProduct(@PathVariable("product-id") Integer productId) {
        productService.deleteProduct(productId);
        return "redirect:/product";
    }

    @PostMapping("/product/{product-id}/update")
    public String update(@PathVariable("product-id") Integer productId) {
        return "redirect:/product";
    }

//25:27
    @GetMapping("/product/{product-id}/props")
    public String getPropByUser(Model model, @PathVariable("product-id") Integer productId) {
        List<Prop> props = productService.getPropByUser(productId);
        List<Prop> unusedProps = productService.getPropWithoutOwner();
        model.addAttribute("productId", productId);
        model.addAttribute("props", props);
        model.addAttribute("unusedProps", unusedProps);
        return "props_of_product";
    }

    @PostMapping("/product/{product-id}/props")
    public String addPropToProduct(@PathVariable("product-id") Integer productId, @RequestParam("propId") Integer propId) {
        productService.addPropToProduct(productId, propId);
        return "redirect:/product/" + productId + "/props";
    }
}
