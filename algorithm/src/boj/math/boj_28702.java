package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class boj_28702 {
    public boolean isNumber(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
    public String solution(String[] strings) {
        String answer = "";
        Set<String> set = new HashSet<>(Arrays.asList("Fizz", "Buzz", "FizzBuzz"));
        int n = 0;
        for (int i = 0; i < 3; i++) {
            if(!set.contains(strings[i])) {
                n = Integer.parseInt(strings[i]) + 3 - i;
            }
        }
        if(n % 15 == 0) answer = "FizzBuzz";
        else if( n % 3 == 0) answer = "Fizz";
        else if( n % 5 == 0) answer = "Buzz";
        else answer = String.valueOf(n);
        return answer;

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
