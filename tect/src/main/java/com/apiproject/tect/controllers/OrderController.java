package com.apiproject.tect.controllers;

import com.apiproject.tect.entities.AppUser;
import com.apiproject.tect.entities.Order;
import com.apiproject.tect.security.CustomeUserPrincipal;
import com.apiproject.tect.services.OrderService;
import com.apiproject.tect.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping
    public Iterable<Order> getAllOrders() {
        Iterable<Order> orders = orderService.findAll();
//        System.out.println(orders);
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.find(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        CustomeUserPrincipal auth = userDetailsService.loadUserByUsername(
                (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        order.setUser(new AppUser(auth.getId(), "", ""));
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