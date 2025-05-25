package com.shawoor.productstore.controller;

import com.shawoor.productstore.model.Product;
import com.shawoor.productstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productss")
public class ProductsController {
    private final ProductService productService;

    @Autowired

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/brand")
    public List<Product> getProductsByBrand(@RequestParam String brand) {
        return productService.getProductByBrand(brand);
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPrice(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return productService.getProductByPrice(minPrice, maxPrice);
    }
}
