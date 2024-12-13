package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2578 {
    public boolean check(int[][] board) {
        // 왼쪽 & 오른쪽 & 대각선 줄 확인해야되겠고, 3빙고를 어떻게 확인하는게 좋을까
        for (int i = 0; i < 5; i++) {
            if(board[i])
        }
    }
    public int bingo(int[][] board, int[] host) {
        int answer = 0, count = 0;
        boolean [][] visited = new boolean[5][5];
        // 1. 현재 사회자가 부른 값을, 철수가 적은 빙고판에서 체크해야한다 -> 어떻게 확인할까, 반복문을 사용해야하난?
        for (int i = 0; i < 25; i++) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if(host[i] == board[x][y]){ // 사회자가 부른 숫자와 동일한 빙고판 숫자는 0으로 바꾼다.
                        board[x][y] = 0;
                        count++;
                    }
                    if(count >= 12) {
                        // 최소 12번 후 부터 빙고인지 확인하는 메소드 실행
                        if(check(board)) break;
                    }
                }
            }
        }
        answer = count;
        // 2. 대각선/가로선/세로선이 5개가 완성되었을 경우는 어떻게 코드로 확인할 수 있을까
        return answer;
    }
    public static void main(String[] args) throws IOException {
        boj_2578 T = new boj_2578();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        int[] host = new int[25];
        for (int i = 0; i < 5; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String[] tmp = br.readLine().split(" ");
                // 사회자가 부른 숫자와 동일한 빙고판 숫자는 0으로 바꾼다.
            for (int j = 0; j < 5; j++) {
                host[idx++] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(T.bingo(board, host));
    }
}
