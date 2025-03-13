package com.samsung.bfs.sequenceNode;

import java.util.*;

public class Main {
    int n;
    int m;
    List<Integer>[] list;
    boolean[] visited;
    int[] d;


    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        d = new int[n + 1];
        Arrays.fill(d, -1);

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }
    }

    public void solve() {
        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                BFS(i);
            }
        }
    }

    private void BFS(int i) {
        Queue<Integer> neigbors = new LinkedList<Integer>();
        neigbors.add(i);
        visited[i] = true;
        System.out.print(i + " ");
        d[i] = 0;

        while (!neigbors.isEmpty()) {
            int neigbor = neigbors.poll();
            for (int v : list[neigbor]) { // với mỗi đỉnh v kề với đỉnh đang xet
                if (!visited[v]) {
                    visited[v] = true;
                    System.out.print(v + " ");
                    neigbors.add(v);
                    d[v] = d[neigbor] + 1; // cap nhat khoang cach tu i den v
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
    }
}
