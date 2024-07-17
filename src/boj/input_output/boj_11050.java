package boj.input_output;

import java.util.Scanner;

// 이항계수(Binomial Coefficient)는 조합론에서 등장하는 개념으로
// 주어진 크기 집합에서 원하는 개수만큼 순서없이 뽑는 조합의 가짓수를 일컫는다.
public class boj_11050 {
    public static int binomialCoefficient(int n, int k) {
        if(k == 0 || n == k) return 1;
        return binomialCoefficient(n-1, k)
                + binomialCoefficient(n-1, k-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(binomialCoefficient(N, K));
    }
}
