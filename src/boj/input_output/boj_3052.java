package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class boj_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            int tmp = Integer.parseInt(br.readLine());
            set.add(tmp%42);
        }
        System.out.println(set.size());
    }
}
