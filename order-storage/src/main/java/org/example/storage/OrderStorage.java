package org.example.storage;

import org.example.products.OrderProcessor; // Correct import
import org.example.thread.OrderThreadManager;

import java.util.List;

public class OrderStorage {
    public void SaveOrder(OrderProcessor order) {
        System.out.println("Order saved ");
    }
    public void startParallelProcessing(List<OrderProcessor> orders) {
        orders.forEach(order-> OrderThreadManager.startProcessing(()->{
            System.out.println("Processing " + order.getProductClassName() + " in thread: " + Thread.currentThread().getName());
        }));
    }
}

