package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] A = new int[num+1];
        int[] dp = new int[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= num; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // input end
        A[0] = dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = Math.max(dp[i-1]+A[i], A[i]);
            System.out.println(dp[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= num; i++) {
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}
