package com.samsung.Backtracking.BalancedCourses;

import java.util.*;

public class Main {
    int m, n; // số lượng giảng viên và khóa học
    List<Integer>[] D; // D[i]: danh sách giảng viên có thể dạy khóa i
    boolean[][] conflict; // Ma trận xung đột giữa các khóa học
    int[] load; // Số lượng khóa học của từng giảng viên
    int[] x; // x[i] là giảng viên được gán cho khóa học i
    int loadMin = Integer.MAX_VALUE; // Giá trị tải trọng nhỏ nhất

    public void input() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        // Khởi tạo danh sách giảng viên có thể dạy từng khóa học
        D = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            D[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int c = sc.nextInt();
                D[c].add(i); // Giảng viên i có thể dạy khóa học c
            }
        }

        // Khởi tạo ma trận xung đột
        conflict = new boolean[n + 1][n + 1];
        int K = sc.nextInt();
        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            conflict[i][j] = true;
            conflict[j][i] = true; // Đồ thị vô hướng
        }

        // Khởi tạo các mảng
        load = new int[m + 1];
        x = new int[n + 1];

        sc.close();
    }

    public boolean canAssign(int course, int teacher) {
        // Kiểm tra ràng buộc xung đột: khóa học này có trùng với khóa học đã được giao cho giảng viên này không?
        for (int i = 1; i < course; i++) {
            if (x[i] == teacher && conflict[i][course]) {
                return false;
            }
        }
        return true;
    }

    public void Try(int k) {
        if (k > n) {
            int maxLoad = Arrays.stream(load).max().getAsInt();
            loadMin = Math.min(loadMin, maxLoad);
            return;
        }

        for (int teacher : D[k]) {
            if (canAssign(k, teacher)) {
                x[k] = teacher; // Gán giảng viên cho khóa học k
                load[teacher]++;

                int currentMaxLoad = Arrays.stream(load).max().getAsInt();
                if (load[teacher] < loadMin) { // Cắt nhánh nếu giá trị hiện tại vượt quá tối ưu
                    Try(k + 1);
                }

                // Hoàn tác gán
                load[teacher]--;
                x[k] = 0;
            }
        }
    }

    public void solve() {
        Try(1);
        System.out.println(loadMin == Integer.MAX_VALUE ? -1 : loadMin);
    }

    public static void main(String[] args) {
        Main solver = new Main();
        solver.input();
        solver.solve();
    }
}
