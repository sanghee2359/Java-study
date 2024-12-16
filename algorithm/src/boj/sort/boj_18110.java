package boj.sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_18110 {
    private int solution(int[] opinions) {
        int n = opinions.length;
        int line = (int) Math.round(n * 0.15);
        double sum = 0;
        // 모든 의견을 정렬
        Arrays.sort(opinions);

        for (int i = line; i < n-line; i++) {
            sum += opinions[i];
        }

        return (int) Math.round(sum / (n - line * 2));
    }
    public static void main(String[] args) throws IOException {
        boj_18110 T = new boj_18110();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] opinions = new int[n];
        for (int i = 0; i < n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(T.solution(opinions));
    }
}
