package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해
// 민규가 지불해야 하는 금액의 최댓값을 구하는 프로그램
public class boj_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 필요한 카드 개수 N개
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] =Math.max(dp[i], dp[i-j]+arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
