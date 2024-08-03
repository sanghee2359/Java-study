package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertLetterCase {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        String answer = "";

        for (char x: arr) {
            if(x >= 97 && x <= 122) answer += (char)(x - 32);
            else answer += (char)(x + 32);
        }

        System.out.println(answer);

    }

}
