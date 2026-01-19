package com.store.main;

import com.store.order.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderApp {

    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();

        orders.add(new OnlineOrder(10001, 1500));
        orders.add(new OnlineOrder(10002, 2500));
        orders.add(new OnlineOrder(10003, 3500));
        orders.add(new OnlineOrder(10004, 5500));

        orders.get(1).cancelOrder();

        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(order.getOrderSummary());

            if (order.getStatus() == OrderStatus.CANCELLED) {
                iterator.remove();
            }
        }

        System.out.println("\nRemaining Orders:");
        for (Order order : orders) {
            System.out.println(order.getOrderSummary());
        }
    }
}