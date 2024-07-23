package boj.brute_force;

import java.util.Scanner;

// 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
// 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
// 1 ≤ N ≤ 1,000,000
public class boj_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long sum = 0;

        for (int i = 1; i < N; i++) {
            String tmp = String.valueOf(i);
            sum = i;
            for (int j = 0; j < tmp.length(); j++) {
                sum += (tmp.charAt(j) - '0');
            }
            if(sum == N) { // N의 생성자 중 가장 작은 i를 찾음
                System.out.println(i);
                return;
            }
        }
        System.out.println(0); // 생성자가 없는 경우
    }
}
