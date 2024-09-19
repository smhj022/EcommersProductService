package com.smhj.ProductService.repos;

import com.smhj.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// no implementation is required
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Optional -> we only get the product if it is not null
    Optional<Product> findById(Long id);
    Optional<List<Product>> findByCategoryName(String category);
}
