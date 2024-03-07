package com.example.products.service.impl;

import com.example.products.model.Category;
import com.example.products.model.Product;
import com.example.products.model.exceptions.InvalidCategoryIdException;
import com.example.products.model.exceptions.InvalidProductIdException;
import com.example.products.repository.CategoryRepository;
import com.example.products.repository.ProductRepository;
import com.example.products.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(InvalidProductIdException::new);
    }

    @Override
    public Product create(String name, Double price, Integer quantity, List<Long> categories) {
        List<Category> categoryList = categoryRepository.findAllById(categories);
        Product product = new Product(name, price, quantity, categoryList);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, String name, Double price, Integer quantity, List<Long> categories) {
        Product product = findById(id);
        List<Category> categoryList = categoryRepository.findAllById(categories);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategories(categoryList);

        return productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product = findById(id);
        productRepository.deleteById(id);
        return product;
    }

    @Override
    public List<Product> listProductsByNameAndCategory(String name, Long categoryId) {
        Category category = categoryId != null ? categoryRepository.findById(categoryId).orElseThrow(InvalidCategoryIdException::new) : null;
        String nameLikePattern = "%" + name + "%";

        if( name != null && category != null){
            return productRepository.findAllByNameLikeAndCategoriesContaining(nameLikePattern, category);
        }
        if( name != null){
            return productRepository.findAllByNameLike(nameLikePattern);
        }
        if( category != null){
            return productRepository.findAllByCategoriesContaining(category);
        }
        return listAllProducts();
    }
}
