package com.shawoor.products.repository;

import com.shawoor.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleContainingIgnoreCase(String searchTerm);

    List<Product> findByPriceBetween(int startPrice, int endPrice);

    List<Product> findByDescriptionContainingIgnoreCaseAndRating(String description, float rating);

    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByCategoryContainingIgnoreCase(String category);

    List<Product> findByBrandAndCategoryContainingIgnoreCase(String brand, String category);

    List<Product> findByTitleAndBrandAndCategoryContainingIgnoreCase(String title, String brand, String category);

    List<Product> findByCategoryContainingIgnoreCaseOrderByTitle(String category);

    List<Product> findAllByOrderByPriceDesc();
}
