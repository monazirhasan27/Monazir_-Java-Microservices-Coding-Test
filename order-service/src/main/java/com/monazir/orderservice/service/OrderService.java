package com.monazir.orderservice.service;

import com.monazir.orderservice.exception.MissingRequiredField;
import com.monazir.orderservice.exception.OrderNotFoundException;
import com.monazir.orderservice.model.Order;
import com.monazir.orderservice.model.Status;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    private final Map<String, Order> orderMap = new HashMap<>();

    public Order createOrder(String customerName, Double amount) {

        if(customerName == null || customerName.isBlank()) {
            throw new MissingRequiredField("Customer name is required");
        }

        if(amount == null || amount <= 0) {
            throw new MissingRequiredField("Amount must be greater than zero");
        }

        String orderId = UUID.randomUUID().toString();

        Order order = new Order(orderId, customerName, amount, Status.NEW);

        orderMap.put(orderId, order);

        return order;
    }

    public Order getOrderById(String orderId) {

        Order order = orderMap.get(orderId);

        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }

        return order;
    }

    public List<Order> getAllOrders() {

        return new ArrayList<>(orderMap.values());
    }

    public Order updateStatus(String orderId) {

        Order order = getOrderById(orderId);

        if (order.getOrderStatus() == Status.NEW) {
            order.setOrderStatus(Status.PROCESSING);
        }
        else if (order.getOrderStatus() == Status.PROCESSING) {
            order.setOrderStatus(Status.COMPLETED);
        }
        else {
            throw new RuntimeException("Order already completed");
        }

        return order;
    }
}