package ps.dfs;

import java.util.Scanner;
// 중복 순열 구하기 : 1~N 번호가 적힌 구슬이 있는데, 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력한다
public class PermutationRepetition {
//    static int[][] arr;
    static int [] arr;
    static int n,m;
    public void DFS(int L, int M) {
        if(M == m) {
            System.out.printf(L+" ");
            for (int i = 0; i <= arr.length; i++) {
                if(arr[i] == 1) System.out.println(i);
            }
        }
        else{
            for (int i = 1; i <= n; i++) {
                arr[i] = 1;
                DFS(i, M+1);
                arr[i] = 0;
            }
        }
    }
    public static void main(String[] args) {
        PermutationRepetition O = new PermutationRepetition();
        Scanner in = new Scanner(System.in);
        // 구술의 수
        n = in.nextInt();
        // 중복을 허락하여 m번을 뽑아 일렬로 나열하는 방법 출력
        int m = in.nextInt();
        arr = new int[n+1];
        O.DFS(0,1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println();arr[i][0] = in.nextInt();
//            arr[i][1] = in.nextInt();
//        }
    }
}