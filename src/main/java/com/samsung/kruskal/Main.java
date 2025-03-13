package com.samsung.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Edge {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.w = w;
        this.v = v;
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
    List<Edge> edges;
    int[] parent;
    int[] rank;

    public void makeSet(int x) {
        parent[x] = x;
        rank[x] = 0;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
        }
    }

    public void kruskal() {
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int v = 1; v <= n; v++) {
            makeSet(v);
        }
        int res = 0;
        Set<Edge> set = new HashSet<>();
        for (Edge e : edges) {
            int ru = find(e.u);
            int rv = find(e.v);
            if (ru != rv) {
                res += e.w;
                union(ru, rv);
                set.add(e);
                if (set.size() == n - 1) {
                    break;
                }
            }
        }
        System.out.println(res);
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] s = line.split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        edges = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            line = br.readLine();
            s = line.split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            edges.add(new Edge(u, v, w));
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.input();
        m.kruskal();
    }
}
