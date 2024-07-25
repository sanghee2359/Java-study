package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String str = br.readLine();
        // 반복문으로 자르는게 좋을까?
        int len = 10;
        while(str.length()>len){
            System.out.println(str.substring(0,len));
            str = str.substring(len);
        }
        System.out.println(str);
        br.close();
    }
}
