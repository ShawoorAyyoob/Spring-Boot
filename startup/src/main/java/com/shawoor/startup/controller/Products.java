package com.shawoor.startup.controller;

import com.shawoor.startup.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Products {
    @GetMapping("/products")
    public List<Product> getProducts(){
        Product product1 = new Product(101L, "Alex", 900, "Apple", "Electronics");
        Product product2 = new Product(102L, "Jones", 500, "Samsung", "Electronics");
        Product product3 = new Product(103L, "Harry", 400, "Huawei", "Electronics");
        Product product4 = new Product(104L, "Finn", 800, "Iqoo", "Electronics");

        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        return products;
    }
}
