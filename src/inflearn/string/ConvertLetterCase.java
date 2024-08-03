package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertLetterCase {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        String answer = "";

        for (char x : arr) {
            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else answer += Character.toLowerCase(x);
        }

        System.out.println(answer);

    }

}
