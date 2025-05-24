package com.shawoor.products.controller;

import com.shawoor.products.model.Product;
import com.shawoor.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productServices) {
        this.productService = productServices;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @GetMapping("/search")
    public List<Product> getProductsByTitle(@RequestParam String searchTerm) {
        return productService.getProductsByTitle(searchTerm);
    }

    @GetMapping("/price-range")
    public List<Product> getProductsByPrice(@RequestParam int startPrice, @RequestParam int endPrice) {
        return productService.getProductsByPrice(startPrice, endPrice);
    }

    @GetMapping("/description-rating")
    public List<Product> getProductsByDescriptionAndRating(@RequestParam String description, @RequestParam float rating) {
        return productService.getProductsByDescriptionAndRating(description, rating);
    }

    @GetMapping("/brand")
    public List<Product> getProductByBrand(@RequestParam String brand) {
        return productService.getProductByBrand(brand);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/brand-category")
    public List<Product> getProductsByBrandAndCategory(@RequestParam String brand, @RequestParam String category) {
        return productService.getProductsByBrandAndCategory(brand, category);
    }

    @GetMapping("/advanced")
    public List<Product> getProductsByTitleBrandAndCategory(@RequestParam String title, @RequestParam String brand, @RequestParam String category) {
        return productService.getProductsByTitleBrandAndCategory(title, brand, category);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        return productService.postProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
