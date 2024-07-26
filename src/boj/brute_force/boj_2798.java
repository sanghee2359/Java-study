package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2798 {

    static int search(int[] arr, int N, int M) {
        int result = 0;

        // 처음 세 개가 3장의 카드일 때부터
        // 마지막 세 개가 3장의 카드에 속할 때까지 모두 탐색
        for (int i = 0; i < N - 2; i++) { // 첫번째 카드는 n-2까지만 순회
            if(arr[i] > M) continue;
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int tmp = arr[i]+arr[j]+arr[k];
                    if(tmp < M) result = Math.max(tmp, result);
                    else if(tmp == M) return M;
                }
            }

        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        for (int i = 0; i < N; i++) {
//
//        }
        int result = search(arr, N, M);
        System.out.println(result);
    }
}
