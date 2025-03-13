package com.samsung.dfs.SequenceNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
        System.out.print(v + " ");
        for (int neigbor : list[v]) {
            if (!visited[neigbor]) {
                DFS(neigbor);
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

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
    }
}
