package com.apiproject.tect.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "new_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @ManyToOne(targetEntity = AppUser.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private AppUser user;

//    @JsonBackReference
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private Set<NewOrderProduct> products;

    @ManyToMany
    @JoinTable(
        name = "new_order_product",
        joinColumns = @JoinColumn(name = "new_order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    Set<Product> products;

    public Order(int id, String description, AppUser user, Set<Product> products) {
        this.id = id;
        this.description = description;
        this.user = user;
        this.products = products;
    }

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
