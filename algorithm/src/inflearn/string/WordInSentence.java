package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordInSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int max = Integer.MIN_VALUE;
        String answer = "";

        int pos = 0;
        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            str = str.substring(pos+1);

            if(tmp.length() > max) {
                max = tmp.length();
                answer = tmp;
            }
        }
        if(str.length() > max) answer = str;
        System.out.println(answer);
    }
}
