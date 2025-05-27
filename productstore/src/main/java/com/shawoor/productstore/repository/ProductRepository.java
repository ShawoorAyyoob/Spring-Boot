package com.shawoor.productstore.repository;

import com.shawoor.productstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByPriceBetween(int minPrice, int maxPrice);

    List<Product> findByTitleStartingWith(String prefix);
}
