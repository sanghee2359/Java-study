package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2193 {
    //이친수는 0으로 시작하지 않는다.
    //이친수에서는 1이 두 번 연속으로 나타나지 않는다.
    // 즉, 11을 부분 문자열로 갖지 않는다.
    static long [][] dp;
    static int N;
    public static long recur(int digit, int val) {
        if(digit == N && val != 1) return 0;
        if(digit == 1) return dp[digit][val];
        if(dp[digit][val] == 0) {
            if(val == 1) dp[digit][val] = recur(digit - 1, 0);
            else if( val == 0) {
                dp[digit][val] = recur(digit - 1, 0) + recur(digit - 1, 1);
            }
        }
        return dp[digit][val];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1; // 1의 자리수에서 가능한 개수는 1뿐.

        long result = 0;
        for (int i = 0; i < 2; i++) {
            result += recur(N, i);
        }
        System.out.println(result);
    }
}
