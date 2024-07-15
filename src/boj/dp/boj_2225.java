package boj.dp;

import java.util.Scanner;

public class boj_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1 <= N <= 200
        int K = sc.nextInt(); // 1 <= K <= 200
        int[][] dp = new int[201][201];

        for(int i=1;i<=K;i++) {
            dp[i][0]=1;
        }
        for(int i=1;i<=K;i++) {
            for(int j=1;j<=N;j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000000; // 1000000000으로 나누는 걸 출력할 때 주면 틀렸다고 뜸.
            }
        }
        System.out.println(dp[K][N]);
    }

}
