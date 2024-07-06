package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String str = "";
        while(!(str = br.readLine()).equals("0")){
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if(sb.reverse().toString().equals(str)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
