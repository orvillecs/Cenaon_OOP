package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new OnlineOrder(100001, 100));
        
        orders.add(new OnlineOrder(100002, 500));
        
        orders.add(new OnlineOrder(100003, 700));
        
        orders.add(new OnlineOrder(100004, 1100));

        orders.get(2).cancelOrder();

        System.out.println("All Orders:");
        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());

            if (order.getStatus() == OrderStatus.CANCELLED) {
                System.out.println("Removing cancelled order.");
                iterator.remove();
            }
        }

        System.out.println("\nRemaining Orders:");
        for (Order order : orders) {
                System.out.println(order.getOrderSummary());
            }
        }
    }