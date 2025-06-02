package com.shawoor.products.controller;

import com.shawoor.products.model.Product;
import com.shawoor.products.model.ResponseMessage;
import com.shawoor.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Error with fetching Product " + id);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(product);
        }
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
    public List<Product> getProductsByTitleAndBrandAndCategory(@RequestParam String title, @RequestParam String brand, @RequestParam String category) {
        return productService.getProductsByTitleAndBrandAndCategory(title, brand, category);
    }

    @GetMapping("/category-title")
    public List<Product> getProductsByCategoryAndTitle(@RequestParam String category) {
        return productService.getProductsByCategoryAndTitle(category);
    }

    @GetMapping("/price-desc")
    public List<Product> getProductsByPriceDesc() {
        return productService.getProductsByPriceDesc();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productService.updateProduct(id, productDetails);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Error with Updating Product " + id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
        }

    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        if (product == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
    }

    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id)
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        boolean status = productService.deleteProduct(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("Error with Deleting Product " + id);
        if (status) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }
    }
}
