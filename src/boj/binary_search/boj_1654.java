package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1654 {
    public static int[] v;
    public static int N;
    public static boolean Check(long mid) { // 여기를 수정해야겠군
        long sum = 0;
        for (int i = 0; i < v.length; i++) {
            long calc = v[i] / mid;
            sum += calc;
        }
        return sum >= N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        v = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            v[i] = Integer.parseInt(br.readLine());
            max = Math.max(v[i], max);
        }
        // input
        max ++; // max와 mid가 같은 값이 되어,
        // mid = (max-min)/ 2 할 때 0이되는 걸 방지하기 위함
        long min = 0;
        while(min < max){
            long mid  = (min + max) / 2;
            if(Check(mid)) min = mid+1;
            else max = mid;
        }
        System.out.println(min-1);
    }
}
