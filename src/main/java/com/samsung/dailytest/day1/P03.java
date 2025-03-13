
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Order> orders = new ArrayList<>();


        int totalOrders = 0;
        int totalRevenue = 0;
        Map<String, Integer> shopRevenue = new HashMap<>();
        Map<String, Map<String, Integer>> customerShopRevenue = new HashMap<>();


        int[] revenueBySecond = new int[86401];


        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }
            String[] parts = line.split(" ");
            String customerId = parts[0];
            String productId = parts[1];
            int price = Integer.parseInt(parts[2]);
            String shopId = parts[3];
            String timePoint = parts[4];


            Order order = new Order(customerId, productId, price, shopId, timePoint);
            orders.add(order);


            totalOrders++;
            totalRevenue += price;


            shopRevenue.put(shopId, shopRevenue.getOrDefault(shopId, 0) + price);


            customerShopRevenue.computeIfAbsent(customerId, k -> new HashMap<>());
            Map<String, Integer> shopMap = customerShopRevenue.get(customerId);
            shopMap.put(shopId, shopMap.getOrDefault(shopId, 0) + price);


            int timeInSeconds = timeToSeconds(timePoint);
            revenueBySecond[timeInSeconds] += price;
        }


        for (int i = 1; i <= 86400; i++) {
            revenueBySecond[i] += revenueBySecond[i - 1];
        }


        while (true) {
            String line = br.readLine();
            if (line.equals("#")) {
                break;
            }

            String[] parts = line.split(" ");
            String queryType = parts[0];

            switch (queryType) {
                case "?total_number_orders":
                    System.out.println(totalOrders);
                    break;

                case "?total_revenue":
                    System.out.println(totalRevenue);
                    break;

                case "?revenue_of_shop":
                    String shopID = parts[1];
                    System.out.println(shopRevenue.getOrDefault(shopID, 0));
                    break;

                case "?total_consume_of_customer_shop":
                    String customerID = parts[1];
                    String shopID2 = parts[2];
                    Map<String, Integer> shopMap = customerShopRevenue.getOrDefault(customerID, new HashMap<>());
                    System.out.println(shopMap.getOrDefault(shopID2, 0));
                    break;

                case "?total_revenue_in_period":
                    int fromTimeInSeconds = timeToSeconds(parts[1]);
                    int toTimeInSeconds = timeToSeconds(parts[2]);


                    int result = revenueBySecond[toTimeInSeconds] -
                            (fromTimeInSeconds > 0 ? revenueBySecond[fromTimeInSeconds - 1] : 0);
                    System.out.println(result);
                    break;
            }
        }
    }
}