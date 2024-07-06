package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;


public class boj_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i,0);
        }
        int multiple = 1;
        for (int i = 0; i < 3; i++) {
            int tmp = Integer.parseInt(br.readLine());
            multiple *= tmp;
        }
        String result = Integer.toString(multiple);
        for (int i = 0; i < result.length(); i++) {
            int key = result.charAt(i)-'0';
            int value = map.get(key);
            map.put(key, ++value);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(map.get(i));
        }
    }
}
