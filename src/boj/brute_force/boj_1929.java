package boj.brute_force;

import java.util.Scanner;

// 소수 구하기
public class boj_1929 {
    // 1 <= M <= N <= 1,000,000
    public static int[] prime;
    void primeNumber(int min, int max) {
        for (int i = 2; i <= max; i++) {
            prime[i] = i;
        }
        for (int i = 2; i <= max ; i++) {
            if(prime[i] == 0) continue;
            for (int j = 2*i; j <= max; j+=i) { // 지워지지 않은 숫자라면 그 배수부터 출발하여, 가능한 모든 숫자 지우기
                prime[j] = 0;
            }
        }
        for (int i = min; i <= max; i++) {
            if(prime[i] != 0) System.out.println(prime[i]);
        }
    }
    public static void main(String[] args) {
        boj_1929 T = new boj_1929();
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        prime = new int[1000001];
        T.primeNumber(min, max);
    }
    //
}
