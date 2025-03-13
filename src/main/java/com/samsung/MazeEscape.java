package com.samsung;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeEscape {
    static class Point {
        int row;
        int col;
        int steps;

        public Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static int solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] maze = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[n + 1][m + 1]; // is visited
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visited[i][j] = false;
            }
        }
        Queue<Point> q = new LinkedList<>();
        Point p0 = new Point(r, c, 0);
        visited[r][c] = true;
        q.add(p0);
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Point p = q.remove();

            for (int k = 0; k < 4; k++) {
                int nr = p.row + dr[k];
                int nc = p.col + dc[k];
                if (nr < 1 || nc < 1 || nr > n || nc > m) {
                    return p.steps + 1;
                }
                if (maze[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, p.steps + 1));
                }
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
