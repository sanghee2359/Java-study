package ps.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 10이하 자연수 N이 주어지면
// 이 중에 M개를 뽑아 일렬로 나열 가능한 모든 순열을 출력하는 프로그램
// 중복 순열 아님
public class LookForPermutation {
    static int n, m;
    static int[] pm; // result
    static int[] arr, visited; //
    public void DFS(int L){
        if(L==m){
            for (int x: pm) {
                System.out.printf(x+" ");
            }
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        LookForPermutation O = new LookForPermutation();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 자연수 개수
        m = in.nextInt(); // 뽑을 자연수 개수
        arr = new int[n];
        visited = new int[n];
        pm = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        O.DFS(0);
    }
}
