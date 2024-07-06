package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String [] str = new String[3];
        int [] num = new int[3];
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            num[i] = Integer.parseInt(str[i]);
        }
        System.out.println(num[0] + num[1] - num[2]);
        int stringNum = Integer.parseInt(str[0] + str[1]) - num[2];
        System.out.println(stringNum);
    }
}
