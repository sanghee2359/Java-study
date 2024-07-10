package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2805 {
    public static int N, M;
    public static int[] v;
    public static boolean Check(int mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(v[i] > mid) sum += v[i]-mid;
        }
        return sum >= M; // 필요한 통나무 길이를 만족하는가
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        v = new int[N];
        st = new StringTokenizer(br.readLine() , " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
            max = Math.max(v[i], max);
        }
        int min = 0;
        max++;
        while(min < max) {
            int mid = (min + max) / 2;
            if(Check(mid)) min = mid + 1;
            else max = mid;
        }
        System.out.println(min - 1);
    }
}
