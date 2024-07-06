package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커는 2행 n열로 배치
// 스티커를 한 장 떼면, 그 스티커와 맞닿아 있는 스티커는 모두 찢어진다고 한다.
// *(최대값 구하기)스티커에 각 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려한다.
// 즉, 2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
public class boj_9465 {
    //    public int recur(int location, int val) {
//
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(input[k - 1]);
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }

}
