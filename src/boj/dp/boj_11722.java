package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11722 {
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
        for (int i = 1; i <= num; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if(sequence[i] < sequence[j]
                        && dp[j] > max) max = dp[j];
            }
            dp[i] = max+1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= num; i++) {
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }

}
