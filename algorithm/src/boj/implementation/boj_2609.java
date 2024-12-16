package boj.implementation;

import java.util.Scanner;

public class boj_2609 {
    public static int gcd(int A, int B) {
        while(B != 0) {
            int remain = A % B;
            A = B;
            B = remain; // 나머지가 0이될 때까지 반복
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 유클리드 호제법
        // A / B -> 나눈수 B / 나머지 ... -> 나머지==0일 때의 나눈수가 최대공약수이다.

        // 재귀
        int gcd = A % B != 0 ? gcd(B, A % B) : B;
        int lcm = A * B /gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
