package com.samsung.CountConnectedGraph;

import java.util.*;

public class Main {
    int n;
    int m;
    List<Integer>[] list;
    boolean[] visited;

    public void DFS(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
//        System.out.print(v + " ");
        for (int neigbor : list[v]) {
            if (!visited[neigbor]) {
                DFS(neigbor);
            }
        }
    }

    private void BFS(int start) {
        Queue<Integer> neigbors = new LinkedList<Integer>();
        neigbors.add(start);
        visited[start] = true;
//        System.out.print(start + " ");

        while (!neigbors.isEmpty()) {
            int neigbor = neigbors.poll();
            for (int v : list[neigbor]) { // với mỗi đỉnh v kề với đỉnh đang xet
                if (!visited[v]) {
                    visited[v] = true;
//                    System.out.print(v + " ");
                    neigbors.add(v);

                }
            }
        }
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
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
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
//                DFS(i);
                BFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
    }
}
