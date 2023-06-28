package ps.array;
// N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 합을 출력

import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        MaximumSum T = new MaximumSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        } // input
        System.out.println(T.solution(n, board));
    }

    private int solution(int n, int[][] board) {
        int answer = Integer.MIN_VALUE; // 최대값 저장
        int sum1, sum2; // 행의 합, 열의 합
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += board[i][j]; // 행 i로 고정, 열의 합을 저장
                sum2 += board[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += board[i][i]; // 대각선
            sum2 += board[i][n-i-1]; // 반대 대각선
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }
}
