package com.samsung.dailytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Order {
    String CustomerID;
    String ProductID;
    Integer Price;
    String ShopID;
    String TimePoint;

    public Order(String CustomerID, String ProductID, Integer Price, String ShopID, String TimePoint) {
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
        this.Price = Price;
        this.ShopID = ShopID;
        this.TimePoint = TimePoint;
    }
}

public class P03 {
    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Order> orders = new ArrayList<Order>();
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] parts = line.split(" ");
            Order order = new Order(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
            orders.add(order);
        }
        int[] ordersAtTimePoint = new int[86401];
        int[] orderInTimeZone = new int[86401];

        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] parts = line.split(" ");
            String queryType = parts[0];
            switch (queryType) {
                case "?total_number_orders":
                    System.out.println(orders.size());
                    break;
                case "?total_revenue":
                    int sum = 0;
                    for (Order order : orders) {
                        sum += order.Price;
                    }
                    System.out.println(sum);
                    break;
                case "?revenue_of_shop":
                    String shopID = parts[1];
                    int revenue_of_shop = 0;
                    for (Order order : orders) {
                        if (order.ShopID.equals(shopID)) {
                            revenue_of_shop += order.Price;
                        }
                    }
                    System.out.println(revenue_of_shop);
                    break;
                case "?total_consume_of_customer_shop":
                    String customerID = parts[1];
                    String shopID2 = parts[2];
                    int revenue_of_customer_shop = 0;
                    for (Order order : orders) {
                        if (order.ShopID.equals(shopID2) && order.CustomerID.equals(customerID)) {
                            revenue_of_customer_shop += order.Price;
                        }
                    }
                    System.out.println(revenue_of_customer_shop);
                    break;
                case "?total_revenue_in_period":
                    String fromTime = parts[1];
                    String toTime = parts[2];
                    int revenueInPeriod = 0;
                    for (Order order : orders) {
                        if (order.TimePoint.compareTo(fromTime) >= 0 && order.TimePoint.compareTo(toTime) <= 0) {
                            revenueInPeriod += order.Price;
                        }
                    }
                    System.out.println(revenueInPeriod);
                    break;
            }
        }
    }
}
