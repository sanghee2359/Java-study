package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int [] dp = new int[num.length()+1];// code의 글자 수?

        dp[0] = 1;
        for (int i = 1; i <= num.length(); i++) {
            int tmp = num.charAt(i-1) - '0'; // 숫자
            if(tmp >= 1 && tmp <= 9) { // 10을 넘어가지 않으면
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }
            if(i == 1) continue;
            int prev = num.charAt(i-2) -'0'; // 조건 1 이전 글자가를 합쳐서 10이상 26미만일 때
            if(prev == 0) continue; // 조건 2 이전 글자가 0일 경우 pass
            int value = prev * 10 + tmp;
            if(value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1000000;
            }
        }
        System.out.println(dp[num.length()]);

    }
}
