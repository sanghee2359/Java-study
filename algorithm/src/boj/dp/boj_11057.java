package boj.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다.
// 이때, 인접한 수가 같아도 오름차순으로 친다.
public class boj_11057 {
    // 1 <= N <= 1000
    // 수는 0으로 시작할 수 있다.
    // 10,007 로 나눈 나머지를 출력
    final static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long[N+1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1; // 첫번째 자리값 1로 초기화
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) { // 자리값 0~9 탐색
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k] % MOD;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % MOD);
    }
}
