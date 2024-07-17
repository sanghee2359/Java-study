package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if(strings.contains(tmp)) continue;
            strings.add(tmp);
        }
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() - o2.length() == 0) return o1.compareTo(o2); //사전 순 정렬
                else return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
