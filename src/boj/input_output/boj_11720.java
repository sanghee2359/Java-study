package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;

        for (int i = 0; i < num; i++) {
            sum+= numbers.charAt(i) - '0'; // char을 숫자로 변환
        }
        System.out.println(sum);
    }
}
