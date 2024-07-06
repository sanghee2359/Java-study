package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2675 {
    public String repeat(int num, String str) {
        char[] word = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < num; j++) {
                sb.append(word[i]);
            }
        }
        answer = sb.toString();
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        boj_2675 O = new boj_2675();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] st = br.readLine().split(" ");
            int num = Integer.parseInt(st[0]);
            System.out.println(O.repeat(num, st[1]));
        }
    }
}
