package com.shawoor.productstore.repository;

import com.shawoor.productstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByPriceBetween(int minPrice, int maxPrice);

<<<<<<< HEAD
    List<Product> findByTitleStartingWith(String prefix);
=======
    List<Product> findByBrandContainingIgnoreCaseAndPriceBetween(String brand, int minPrice, int maxPrice);
>>>>>>> 8b6dc2ebd20342addce62617373dc69a51d7a507
}
