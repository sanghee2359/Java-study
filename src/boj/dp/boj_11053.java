package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11053 {
    //부분수열 중 전체가 오름차순으로 정렬된 가장 긴 수열
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
        sequence[0] = dp[0] = 0;
        for (int i = 1; i <= num ; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if(sequence[j] < sequence[i]
                        && max < dp[j]) max = dp[j];
            }
            dp[i] = max+1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= num; i++) {
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}
