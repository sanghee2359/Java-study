package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int max = 2*num -1;
        StringBuilder sb = new StringBuilder();
        for (int i = num; i >= 1; i--) { //뒤집어진 모양 그리기
            for (int j = 0; j < num-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for (int i = 2; i <= num; i++) { // 맞닿는 부분인 별 한개는 출력안함
            for (int j = 0; j < num-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
