package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        int index = Integer.parseInt(br.readLine());
        System.out.println(words[index-1]);
    }
}
