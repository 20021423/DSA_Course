package com.samsung.Backtracking.BalancedCourses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BCA {
    int n,m;
    List<Integer>[] D;// D[i] is the list of teachers can be assigned to course i
    boolean[][] conflict;// conflict[i][j] = true means that courses i and j are scheduled in the same time-slot
    int[] x;// x[i] is the teacher assigned to course i
    int[] load; // load[i] is the number of courses assigned to teacher i
    int loadMin;// best objective value
    public void input(){
        try{
            Scanner in = new Scanner(System.in);
            m = in.nextInt();
            n = in.nextInt();
            D = new List[n+1];
            for(int i = 1; i <= n; i++) D[i] = new ArrayList<>();
            for (int i = 1; i <= m; i++){
                //D[i] = new ArrayList<>();
                //System.out.println("New D[" + i + "]");
                int k = in.nextInt();
                for(int j = 1; j <= k; j++){
                    int c = in.nextInt(); D[c].add(i);
                }
            }
            conflict = new boolean[n+1][n+1];
            for(int i = 1; i <= n; i++)
                for(int j = 1; j <= n; j++)
                    conflict[i][j] = false;
            int K = in.nextInt();
            for(int k = 1; k <= K; k++){
                int i = in.nextInt(); int j = in.nextInt();
                conflict[i][j] = true;
            }
            in.close();
        }catch (Exception e){}
    }
    private boolean check(int v, int k){
        for(int i = 1; i <= k-1; i++){
            if(conflict[i][k] && x[i] == v){
                return false;
            }
        }
        return true;
    }
    private void solution(){
        // compute max-load among teachers
        int maxLoad = 0;
        for(int i = 1; i <= m; i++)
            if(maxLoad < load[i]) maxLoad = load[i];
        if(maxLoad < loadMin){
            loadMin = maxLoad;
            System.out.println("update new best = " + loadMin);
        }
    }
    private void Try(int k){// try all values fo x[k]
        for(int v: D[k]){
            if(check(v,k)){
                x[k] = v; load[v] += 1;
                if(k == n) solution();
                else{
                    if(load[v] < loadMin)
                        Try(k+1);
                }
                load[v] -= 1;// recover when backtracking
            }
        }
    }
    public void solve(){
        x = new int[n+1];
        load = new int[m+1];
        for(int i = 1; i <= m; i++) load[i] = 0;
        loadMin = 10000000;
        Try(1);
        System.out.println("res = " + loadMin);
    }
    public static void main(String[] args){
        BCA app = new BCA();
        app.input();
        app.solve();
    }
}