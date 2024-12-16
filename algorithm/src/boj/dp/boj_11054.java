package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] r_dp = new int[N];
        int[] l_dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // input end
        for (int i = 0; i < N; i++) {
            l_dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // sk인 i보다 작은 값이며, 이전에 선택된 tmp보다 큰 값이면 출력
                if(A[i] > A[j] && l_dp[i] < l_dp[j]+1) {
                    l_dp[i] = l_dp[j]+1;
                }
            }
            System.out.println("l_dp["+i+"]= "+l_dp[i]);
        }
        for (int i = N-1; i >= 0; i--) {
            r_dp[i] = 1;
            for (int j = N-1; j > i; j--) {
                if(A[i] > A[j] && r_dp[i] < r_dp[j]+1) {
                    r_dp[i] = r_dp[j]+1;
                }
            }
            System.out.println("r_dp["+i+"]= "+r_dp[i]);

        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = l_dp[i]+ r_dp[i];
            if(max < tmp) max = tmp;
        }
        System.out.println(max - 1);

    }
}
