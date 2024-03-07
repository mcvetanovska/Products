package com.example.products.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Product {


    public Product() {
    }

    public Product(String name, Double price, Integer quantity, List<com.example.products.model.Category> categories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categories = categories;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    @ManyToMany
    private List<com.example.products.model.Category> categories;

    @ManyToOne
    private User creator;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<com.example.products.model.Category> getCategories() {
        return categories;
    }

    public User getCreator() {
        return creator;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategories(List<com.example.products.model.Category> categories) {
        this.categories = categories;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

}
