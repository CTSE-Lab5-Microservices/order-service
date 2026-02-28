package com.lab5.order_service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lab5.order_service.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);
    
    // private List<Map<String,Object>> orders = new ArrayList<>();
    // private int idCounter = 1;


    @GetMapping
    public List<Order> getAll() {
        return orders;
    }
    
    // @GetMapping
    // public List<Map<String,Object>> getOrders() {
    //     return orders;
    // }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        order.setId(idGen.getAndIncrement());
        order.setStatus("PENDING");
        orders.add(order);
        return order;
    }

    // @PostMapping
    // public ResponseEntity<Map<String,Object>> placeOrder(@RequestBody Map<String,Object> order) {
    //     order.put("id", idCounter++);
    //     order.put("status", "PENDING");
    //     orders.add(order);
    //     return ResponseEntity.status(201).body(order);
    // }
    
    // @GetMapping("/{id}")
    // public ResponseEntity<?> getOrder(@PathVariable int id) {
    //     return orders.stream()
    //     .filter(o -> o.get("id").equals(id))
    //     .findFirst()
    //     .map(ResponseEntity::ok)
    //     .orElse(ResponseEntity.notFound().build());
    // }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orders.stream()
                .filter(o -> Objects.equals(o.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Order not found: " + id));
    }
}