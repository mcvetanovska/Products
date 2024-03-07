package com.example.products.repository;

import com.example.products.model.Category;
import com.example.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameLikeAndCategoriesContaining(String name, Category category);
    List<Product> findAllByNameLike(String name);
    List<Product> findAllByCategoriesContaining(Category category);
}
