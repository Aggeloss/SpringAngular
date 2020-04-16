package com.apiproject.tect.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int quantity;
    private boolean status;

//    @JsonBackReference
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private Set<NewOrderProduct> orders;

    @ManyToMany(mappedBy = "products")
    Set<Order> orders;

    public Product(String name, double price, int quantity, boolean status, Set<NewOrderProduct> orders) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public Product() { }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
