package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11055 {
    // 수열 A의 합이 가장 큰, 증가하는 부분 수열의 합을 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int [] sequence = new int[num+1];
        int[] dp = new int[num+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= num; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        // input end
        sequence[0] = dp[0] = 0;
        for (int i = 1; i <= num ; i++) {
            int max = dp[0] + sequence[i];
            // i번째 항이 최댓값인 경우의 증가수열의 누적합 만들기
            for (int j = 1; j < i; j++) {
               if(sequence[i]> sequence[j]){
                   max = Math.max(max, dp[j]+sequence[i]);
               }
            }
            dp[i] = max;
//            System.out.println("dp["+i+"] = "+ max);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);

    }
}
