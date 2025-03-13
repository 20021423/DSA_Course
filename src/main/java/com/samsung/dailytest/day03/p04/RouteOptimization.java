package com.samsung.dailytest.day03.p04;

import java.util.Scanner;

public class RouteOptimization {
    /**
     * Tính giá trị tối đa hàng hóa mà xe tải có thể lấy được.
     *
     * @param N Số trạm (đánh số từ 1 đến N)
     * @param T Tổng thời gian lấy hàng tối đa
     * @param D Khoảng cách tối đa giữa 2 trạm liên tiếp
     * @param a Mảng hàng hóa tại mỗi trạm (a[1] đến a[N])
     * @param t Mảng thời gian lấy hàng tại mỗi trạm (t[1] đến t[N])
     * @return Giá trị tối đa hàng hóa có thể đạt được.
     */
    public static int maxGoods(int N, int T, int D, int[] a, int[] t) {
        // dp[i][tau] là giá trị tối đa khi lộ trình kết thúc tại trạm i với tổng thời gian là tau
        int[][] dp = new int[N + 1][T + 1];

        // Khởi tạo: Nếu chỉ lấy một trạm, với trạm i, nếu t[i] <= T thì dp[i][t[i]] = a[i]
        for (int i = 1; i <= N; i++) {
            if (t[i] <= T) {
                dp[i][t[i]] = a[i];
            }
        }

        // Chuyển trạng thái: Duyệt qua các trạm i
        for (int i = 1; i <= N; i++) {
            // Với mỗi tổng thời gian đã dùng tau tại trạm i
            for (int tau = 0; tau <= T; tau++) {
                // Nếu trạng thái tại dp[i][tau] chưa có giá trị, bỏ qua
                if (dp[i][tau] == 0) continue;
                // Xét chuyển tiếp đến các trạm j nằm trong khoảng [i+1, min(N, i+D)]
                for (int j = i + 1; j <= Math.min(N, i + D); j++) {
                    int newTime = tau + t[j]; // Tổng thời gian sau khi dừng tại trạm j
                    if (newTime <= T) { // Nếu tổng thời gian không vượt quá T
                        dp[j][newTime] = Math.max(dp[j][newTime], dp[i][tau] + a[j]);
                    }
                }
            }
        }

        // Tìm giá trị tối đa trong bảng dp
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int tau = 0; tau <= T; tau++) {
                ans = Math.max(ans, dp[i][tau]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc dữ liệu đầu vào theo đề bài:
        // Dòng 1: N, T, D
        int N = sc.nextInt();
        int T = sc.nextInt();
        int D = sc.nextInt();

        // Tạo mảng 1-indexed, kích thước N+1, bỏ qua chỉ số 0.
        int[] a = new int[N + 1];
        int[] t = new int[N + 1];

        // Dòng 2: Mảng a (hàng hóa tại các trạm)
        for (int i = 1; i <= N; i++) {
            a[i] = sc.nextInt();
        }

        // Dòng 3: Mảng t (thời gian pickup tại các trạm)
        for (int i = 1; i <= N; i++) {
            t[i] = sc.nextInt();
        }

        // Tính kết quả và in ra
        int result = maxGoods(N, T, D, a, t);
        System.out.println(result);

        sc.close();
    }
}
