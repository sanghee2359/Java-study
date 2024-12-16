package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
// 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
public class boj_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int result = 0;
        for (int i = 0; i < str.length; i++) {
            if(!str[i].equals("")) result++;
        }
        System.out.println(result);
    }
}
