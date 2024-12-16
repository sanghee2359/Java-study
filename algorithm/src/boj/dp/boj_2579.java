package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairScore = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stairScore[i] = Integer.parseInt(br.readLine());
        }
        // input end
        dp[0] = 0;
        dp[1] = stairScore[1];
        if(N >= 2) dp[2] = stairScore[1] + stairScore[2];
        for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i-3] + stairScore[i-1])+ stairScore[i];
        }
        System.out.println(dp[N]);
    }
}
