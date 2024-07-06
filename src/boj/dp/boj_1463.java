package boj.dp;

// 정수 x에 사용할 수 있는 연산은 3가지
// x가 3으로 나누어 떨어지면 3으로 나눔
// x가 2으로 나누어 떨어지면 2으로 나눔
// 1을 뺌

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
// 연산을 사용하는 횟수의 최솟값을 출력
// 1 <= num < 10^6
public class boj_1463 {
    static Integer[] dy;
    public int dp(int n) {
        if (dy[n] == null) {
            if (n % 6 == 0) {
                dy[n] = Math.min(dp(n - 1), Math.min(dp(n / 3), dp(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dy[n] = Math.min(dp(n / 3), dp(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dy[n] = Math.min(dp(n / 2), dp(n - 1)) + 1;
            } else dy[n] = dp(n - 1) + 1;
        }
        return dy[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dy = new Integer[num+1];
        boj_1463 T = new boj_1463();
        dy[0] = dy[1] = 0;
        T.dp(num);
        System.out.println(dy[num]);
    }
}
