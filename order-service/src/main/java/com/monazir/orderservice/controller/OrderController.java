package com.monazir.orderservice.controller;

import com.monazir.orderservice.exception.MissingRequiredField;
import com.monazir.orderservice.model.Order;
import com.monazir.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestParam(required = false) String customerName,
                             @RequestParam(required = false) Double amount) {

        return orderService.createOrder(customerName, amount);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {

        return orderService.getOrderById(orderId);
    }

    @GetMapping
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    @PutMapping("/{orderId}/status")
    public Order updateStatus(@PathVariable String orderId) {

        return orderService.updateStatus(orderId);
    }
}