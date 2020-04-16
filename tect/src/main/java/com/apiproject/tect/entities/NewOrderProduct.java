package com.apiproject.tect.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "new_order_product")
public class NewOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonManagedReference
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @JsonManagedReference
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "new_order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    public NewOrderProduct(int id, Order order, Product product) {
        this.id = id;
        this.order = order;
        this.product = product;
    }

    public NewOrderProduct() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
