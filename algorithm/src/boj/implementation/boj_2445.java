package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int j = 1; j <= 2*num-2*i; j++) {
                sb.append(" ");
            }
            for (int j = 1;j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = num-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            for (int j = 1; j <= 2*num-2*i; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
