package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_8958 {
    public int findScore(String str) {
        int sequence = 0;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'O') {
                sequence++;
                sum += sequence;
            }else if(str.charAt(i) == 'X') sequence = 0;

        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        boj_8958 O = new boj_8958();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            System.out.println(O.findScore(str));
        }

    }
}
