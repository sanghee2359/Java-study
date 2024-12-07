package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_28702 {
    public boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
    // 3의 배수 & 5의 배수
    public String solution(String[] strings)
    {
        int[] numbers = new int[4];
        int idx = 0, cur;
        for (int i = 0; i < strings.length; i++) {
            if(isNumber(strings[i])) {
                cur = Integer.parseInt(strings[i]);
                numbers[i] = cur;
                idx = i + 1;
                break;
            }
        }
        for (int i = idx; i < 4; i++) {
            numbers[i] = numbers[i-1] + 1;
        }
        if(numbers[3] % 3 == 0 && numbers[3] % 5 == 0) return "FizzBuzz";
        else if(numbers[3] % 3 == 0 && numbers[3] % 5 != 0) return "Fizz";
        else if(numbers[3] % 3 != 0 && numbers[3] % 5 == 0) return "Buzz";
        else return Integer.toString(numbers[3]);

    }

    public static void main(String[] args) throws IOException {
        boj_28702 T = new boj_28702();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[3];
        for (int i = 0; i < 3; i++) {
            strings[i] = br.readLine();
        }
        System.out.println(T.solution(strings));
    }
}
