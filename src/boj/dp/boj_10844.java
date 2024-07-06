package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844 {
    // 1<= n <= 100
    // 1,000,000,000으로 나눈 나머지를 출력
    final static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1; // 첫번째 자리값 1로 초기화
        }

        for (int i = 2; i <= N; i++) { // 두 번째 자릿수 부터 탐색
            for (int j = 0; j < 10; j++) { // 자리값 0~9 탐색
                if(j == 0) {
                    dp[i][0] = dp[i - 1][1] % MOD;
                }
                else if (j == 9){
                    dp[i][9] = dp[i - 1][8] % MOD;
                }
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % MOD);
    }
}
