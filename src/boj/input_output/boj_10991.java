package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num-i; j++) {
                sb.append(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                if(j%2 ==1) sb.append("*");
                if(j%2 ==0) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
