package boj.dp;

import java.util.Scanner;

public class boj_1699 {
    public static void main(String[] args) {
        boj_1699 T = new boj_1699();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[100001];
        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 숫자 1로 항이 이루어졌을 때를 가정한 초기화
        }
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j * j<= i ; j++) {
                if(dp[i] > dp[i - (j*j)]+1){
                    // j로 된 제곱수(1항)
                    dp[i] = dp[i - (j*j)]+1;
                }
            }
        }
        System.out.println(dp[N]);
    }
}
