package boj.input_output;
//컴퓨터마다 6자리의 고유번호를 매긴다.
// 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며
// 6번째 자리에는 검증수가 들어간다.
// 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int tmp = Integer.parseInt(numbers[i]);
            sum += tmp*tmp;
        }
        System.out.println(sum%10);
    }
}
