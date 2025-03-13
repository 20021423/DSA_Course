package com.samsung.Backtracking.tsp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n;
    int[][] c; //distance matrix: c[i][j] = the cost of travel from i to j
    int[] x; //solution from x[1],...x[1]
    int f; // travel distance, accumulated during the process
    int fmin;
    boolean[] visited;
    int Cm; // min distance // gia tri can

    public void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = new int[n + 1][n + 1];
        Cm = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                c[i][j] = sc.nextInt();
                if (c[i][j] < Cm) {
                    Cm = c[i][j];
                }
            }
        }
    }

    public boolean check(int v, int k) {
        // return true if the value v can be assigned to x[k] without violating contraints
        return !visited[v];
    }

    public void Try(int k) {
        for (int v = 1; v <= n; v++) {
            if (check(v, k)) {
                x[k] = v;
                visited[v] = true;
                f = f + c[x[k - 1]][x[k]];
                if (k == n) solution();
                else {
                    if (f + Cm * (n - k + 1) < fmin) { // dieu kien nhanh can
                        Try(k + 1);
                    }

                }
                f = f - c[x[k - 1]][x[k]];
                visited[v] = false;
            }
        }
    }

    private void solution() {
        if (f + c[x[n]][x[1]] < fmin) {
            fmin = f + c[x[n]][x[1]];
        }
    }

    public void solve() {
        x = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        fmin = Integer.MAX_VALUE;
        f = 0;
        x[1] = 1;
        visited[1] = true;
        Try(2);
        System.out.println(fmin);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.input();
        m.solve();
    }
}
