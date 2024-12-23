package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_7568 {
    private int[] solution(int[] kg, int[] cm) {
        int n = kg.length;
        int[] answer = new int[n];

        // 겹치지 않는 덩치가 큰 사람들을 먼저 찾는게 나을까?

        for (int i = 0; i < n; i++) {
            int k = 1; // 덩치 등수
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(kg[i] < kg[j] && cm[i] < cm[j]) k++;
            }
            answer[i] = k;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        boj_7568 T = new boj_7568();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] kg = new int[n];
        int[] cm = new int[n];
        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");

            kg[i] = Integer.parseInt(strings[0]);
            cm[i] = Integer.parseInt(strings[1]);

        }
        int[] result = T.solution(kg, cm);
        StringBuilder sb = new StringBuilder();
        for (int rank : result) {
            sb.append(rank).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
