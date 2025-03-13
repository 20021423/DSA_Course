package com.samsung.bfs.shipTravel;

import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {
    int n, m;
    List<Integer>[] adj; // Danh sách kề
    boolean[] visited;
    int[] dist;

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Point[] points = new Point[n + 1];
        adj = new ArrayList[n + 1]; // Danh sách kề
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Đọc tọa độ các đảo
        for (int i = 1; i <= n; i++) {
            int xi = sc.nextInt();
            int yi = sc.nextInt();
            points[i] = new Point(xi, yi);
        }

        sc.close();

        // Tạo danh sách kề bằng cách kiểm tra khoảng cách giữa các đảo
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (points[i].distance(points[j]) <= m) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
    }

    public void solve() {
        int result = BFS(1);
        System.out.println(result);
    }

    private int BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    dist[v] = dist[u] + 1;

                    // Dừng ngay khi đến đảo n
                    if (v == n) {
                        return dist[v];
                    }
                }
            }
        }
        return -1; // Không thể đến đảo n
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
    }
}
