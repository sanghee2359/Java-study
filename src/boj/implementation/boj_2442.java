package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int space = (2*num-1)/2;
        // 삼각형을 이루기 위해, 별 앞 부분의 공백을 구함

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < space-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*(i+1)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
