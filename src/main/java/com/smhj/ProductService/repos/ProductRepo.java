package com.smhj.ProductService.repos;

import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.projection.ProductWithTitleAndDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// no implementation is required
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    // Optional -> we only get the product if it is not null
    // to avoid null pointer exception
    Optional<Product> findById(Long id);

    List<Product> findByTitle(String title);

    //wildcard matching of title
    List<Product> findByTitleContains(String str);

    List<Product> findByTitleAndDescription(String title, String description);


    //Optional<List<Product>> findByCategoryName(String category);

    List<Product> findByCategory(Category category);


    @Override
    void delete(Product entity);

    /*
    * create -> without id;
    * update -> with id;
    * */

    Product save(Product product);

    //List<Product> findByCategory(Object unknownAttr1);
    //HQL
//    @Query("select p.title as title, p.description as description form Product p where p.id = :id")
//    ProductWithTitleAndDescription someRandomQuery(@Param("id") Long id);
//
//
//    //SQL -> Native query
//    @Query(value = "select title, description form product where p.id = :id", nativeQuery = true)
//    ProductWithTitleAndDescription someOtherRandomQuery(@Param("id") Long id);
}
