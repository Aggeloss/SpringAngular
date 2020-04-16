package com.apiproject.tect.controllers;

import com.apiproject.tect.entities.Order;
import com.apiproject.tect.security.CustomeUserPrincipal;
import com.apiproject.tect.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public Iterable<Order> getAllOrders() {
        Iterable<Order> orders = orderService.findAll();
        System.out.println(orders);
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.find(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        CustomeUserPrincipal auth = (CustomeUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long user_id = auth.getId();
//        order.setUser(new AppUser(user_id, "", ""));
        return orderService.save(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.delete(id);
    }
}