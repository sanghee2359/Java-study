package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978 {
    public boolean isPrime(int n) {
        if(n == 1) return false;
        for (int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        boj_1978 T = new boj_1978();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if(T.isPrime(A[i])) sum++;
        }
        System.out.println(sum);
        // A 배열들 중 소수의 개수 구하기

    }
}
