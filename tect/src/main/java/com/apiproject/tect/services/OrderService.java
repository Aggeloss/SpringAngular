package com.apiproject.tect.services;

import com.apiproject.tect.entities.Order;

public interface OrderService {

    public Iterable<Order> findAll();

    public Order find(int id);

    public Order save(Order order);

    public Order update(Order order);

    public void delete(int id);
}
