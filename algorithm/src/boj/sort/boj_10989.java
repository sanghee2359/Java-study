package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// O(NlogN) 보다 빨라야 한다.
public class boj_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] result = new int[N];
        int max = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }
        int[] counting = new int[max+1];

        for (int i = 0; i < N; i++) {
             counting[array[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = N-1; i >= 0; i--) {
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
