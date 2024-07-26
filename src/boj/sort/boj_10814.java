package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10814 {
    public static class Man {
        int age;
        String name;

        public Man(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Man[] list = new Man[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list[i] = new Man(age, name);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(list, new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.age - o2.age; // 나이 오름차순
            }
        });
        for (int i = 0; i < N; i++) {
            sb.append(list[i]);
        }
        System.out.println(sb);
    }
}
