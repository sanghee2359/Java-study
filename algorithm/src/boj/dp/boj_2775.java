package boj.dp;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2775 {
    public int solution(int k, int n) {
        int[][] apart = new int[14][k+1]; // 90도 뒤집어서 배열형태를 유지
        for (int i = 1; i < 14; i++) {
            for (int j = 1; j <= k; j++) {
                apart[0][j] = 1;
                apart[i][0] = i+1;
                apart[i][j] = apart[i-1][j] + apart[i][j-1]; // 방 채우기
            }
        }
        return apart[n-1][k]; // 저장할 때 0층의 열에 +1해서 저장했기 때문에
    }
    public static void main(String[] args) {
        boj_2775 T = new boj_2775();
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int[] answer = new int[test];

        for (int i = 0; i < test; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            answer[i] = T.solution(k, n);
        }
        for (int x : answer) {
            System.out.println(x);
        }
    }
}
