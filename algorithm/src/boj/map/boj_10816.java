package boj.map;
// 정수 M개가 주어졌을 때,
// 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램

// 첫째 줄 N(1 ≤ N ≤ 500,000)
// 둘째 줄 숫자 카드에 적혀있는 정수 (-10,000,000 ≤ 정수 ≤ 10,000,000)
// 셋째 줄에는 M(1 ≤ M ≤ 500,000)
// 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            // key
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp,0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(tmp, 0)).append(" ");
        }

        System.out.println(sb);

    }
}
