package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9461 {
    static long [] dp;
    // 1 <= N <= 100
    public static void main(String[] args) throws IOException {
        boj_9461 T = new boj_9461();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = dp[1] + dp[3];
        for (int i = 0; i < count; i++) {
           int N = Integer.parseInt(br.readLine());
           T.find(N);
           System.out.println(dp[N]);
        }
    }

    public void find(Integer N) {
        for (int i = 5; i <= N; i++) {
            if(dp[i] == 0) {
                dp[i] = dp[i-5] + dp[i-1];
            }
        }

    }
}
