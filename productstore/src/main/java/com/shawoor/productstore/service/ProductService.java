package com.shawoor.productstore.service;

import com.shawoor.productstore.model.Product;
import com.shawoor.productstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByBrand(String brand) {
        return productRepository.findByBrandContainingIgnoreCase(brand);
    }

    public List<Product> getProductByPrice(int minPrice, int maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductByTitle(String prefix) {
        return productRepository.findByTitleStartingWith(prefix);
    // public List<Product> getProductsByBrandAndPrice(String brand, int minPrice, int maxPrice) {
    //     return productRepository.findByBrandContainingIgnoreCaseAndPriceBetween(brand, minPrice, maxPrice);
    // }
}
}