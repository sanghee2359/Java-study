package boj.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018 {
    public static boolean [][] arr;
    public static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'W') arr[i][j] = true;
                else arr[i][j] = false;
            }
        }
        // input end

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }
    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;
        boolean TF = arr[x][y];
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                if(arr[i][j] != TF) { // 올바른 색이 아닐 경우
                    count++;
                }
                TF = !TF; // 양 옆의 타일의 색은 서로 달라야 함
            }
            TF = !TF; // 위 아래 타일의 색은 서로 달라야 함
        }
        // 첫번째 칸 기준으로 할 때 색칠할 개수
        // vs 첫번째 칸의 반대의 색을 기준으로 할 때 색칠할 개수
        // 중 작은 값 저장
        count = Math.min(count, 64 - count);
        min = Math.min(min, count); // 보드에서 자를 수 있는 체스판의 경우의 수
    }
}
