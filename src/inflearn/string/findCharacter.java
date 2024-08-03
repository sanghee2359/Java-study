package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findCharacter {
    // 주의 사항. 대문자이든 소문자이든 비교할 문자와 일치시켜야한다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char c = Character.toLowerCase(br.readLine().charAt(0));

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) sum++;
        }

        System.out.println(sum);
    }

}
