package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2]; // i가 2씩 더해지므로, N+2
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) { // 짝수만 진행
            dp[i] = dp[2] * dp[i-2];
            for (int j = i-4; j >= 0 ; j -= 2) { // 2씩 차이
                dp[i] += 2 * dp[j];
            }
        }
        System.out.println(dp[N]);

    }
}
