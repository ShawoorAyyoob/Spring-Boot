package com.shawoor.products.services;

import com.shawoor.products.model.Product;
import com.shawoor.products.repository.ProductRepository;
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

    public Product getProductById(Long id) {
        Product dummyProduct = new Product();
        dummyProduct.setId(0L);
        dummyProduct.setTitle("No Product Found");
        dummyProduct.setDescription(" ---- ");
        return productRepository.findById(id).orElse(dummyProduct);
    }

    public List<Product> getProductsByTitle(String searchTerm) {
        return productRepository.findByTitleContainingIgnoreCase(searchTerm);
    }

    public List<Product> getProductsByPrice(int startPrice, int endPrice) {
        return productRepository.findByPriceBetween(startPrice, endPrice);
    }

    public List<Product> getProductsByDescriptionAndRating(String description, float rating) {
        return productRepository.findByDescriptionContainingIgnoreCaseAndRating(description, rating);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setTitle(productDetails.getTitle());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setRating(productDetails.getRating());

        return productRepository.save(product);
    }

    public Product postProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}