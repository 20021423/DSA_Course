package com.samsung.dijikstra;

import java.io.IOException;
import java.util.*;

class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}

public class Main {
    int n;
    int m;
    List<Edge>[] A;

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            Edge e = new Edge(u, v, w);
            A[u].add(e);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(dijkstra(start, end));

    }

    public int dijkstra(int start, int end) {
        int d[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[start] = 0;
        Queue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        q.add(new Edge(start, start, 0));
        while (!q.isEmpty()) {
            Edge e = q.poll();
            int u = e.u;
            if (u == end) {
                break;
            }
            for(Edge ed : A[u]) {
                int v = ed.v;
                int newW = ed.w + d[u];
                if (newW < d[v]) {
                    d[v] = newW;
                    q.add(new Edge(v, u, newW));
                }

            }
        }
        return d[end];
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.input();
    }
}
