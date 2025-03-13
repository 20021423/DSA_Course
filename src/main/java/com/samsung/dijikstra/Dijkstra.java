package com.samsung.dijikstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class GNode implements Comparable<GNode> {
    int id;
    int dist;

    public GNode(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(GNode o) {
        return this.dist - o.dist;
    }
}


public class Dijkstra {
    int n;
    int m;
    int start;
    int end;
    List<GNode>[] A; // A[v] chua cac GNode ke voi v

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
            A[u].add(new GNode(v, w));

        }
        start = sc.nextInt();
        end = sc.nextInt();
    }

    public int dijkstra() {
        PriorityQueue<GNode> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        pq.add(new GNode(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            GNode cur = pq.poll(); // lấy ra node có dist nhỏ nhất hiện tại
            int u = cur.id; // lấy ra index của node
            if (u == end) { // nếu index node này bằng end thì dừng
                break;
            }
            for (GNode n : A[u]) { // với mỗi node mà ke với u
                int adj = n.id; // lấy ra tên node kề
                if (dist[adj] > dist[u] + n.dist) { // so sánh dist từ start đến adj có lơn hơn dist của start đến u + n.dist = dist(u,adj)
                    dist[adj] = dist[u] + n.dist;
                    pq.add(new GNode(adj, dist[adj])); // them node mới
                }
            }
        }
        return dist[end];
    }
    public static void main(String[] args) {
        Dijkstra d = new Dijkstra();
        d.input();
        System.out.println(d.dijkstra());
    }
}
