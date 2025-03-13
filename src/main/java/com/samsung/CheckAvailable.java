package com.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class CheckAvailable {
    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 3600 + Integer.parseInt(parts[1]) * 60 + Integer.parseInt(parts[2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        int[] ordersAtTimePoint = new int[86401]; // Use 86401 to include second 86400 (23:59:59)
        int[] orderInTimeZone = new int[86401];   // Same here

        String line;
        while (!(line = scanner.readLine()).equals("#")) {
            String[] parts = line.split(" ");
            int timeInSeconds = timeToSeconds(parts[1]);
            ordersAtTimePoint[timeInSeconds]++;
        }

        // Calculate prefix sum
        for (int i = 1; i <= 86400; i++) {
            orderInTimeZone[i] = ordersAtTimePoint[i] + orderInTimeZone[i - 1];
        }

        while (!(line = scanner.readLine()).equals("###")) {
            String[] parts = line.split(" ");

            if (parts[0].equals("?number_orders")) {
                System.out.println(orderInTimeZone[86400]);
            }
            else if (parts[0].equals("?number_orders_in_period")) {
                int fromTimeInSeconds = timeToSeconds(parts[1]);
                int toTimeInSeconds = timeToSeconds(parts[2]);
                // Need to include both from and to timestamps in the range
                // This is why we subtract (fromTimeInSeconds - 1)
                int result = orderInTimeZone[toTimeInSeconds] -
                        (fromTimeInSeconds > 0 ? orderInTimeZone[fromTimeInSeconds - 1] : 0);
                System.out.println(result);
            }
            else if (parts[0].equals("?number_orders_at_time")) {
                int timeInSeconds = timeToSeconds(parts[1]);
                System.out.println(ordersAtTimePoint[timeInSeconds]);
            }
        }
    }
}
