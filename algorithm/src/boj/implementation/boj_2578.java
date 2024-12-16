package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2578 {
    static int[][] board;
    static int bingo_count = 0;
    public void check(int[][] board) {
        bingo_count = 0;
        // 왼쪽 & 오른쪽 & 대각선 줄을 각각 합하여 0이될 경우 빙고로 처리
        int row = 0, col = 0, xy = 0, yx = 0; // 가로, 세로, 오른쪽 아래 대각선, 왼쪽 아래 대각선
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            row = 0;
            col = 0;
            for (int j = 0; j < 5; j++) {
                row += board[i][j];
                col += board[j][i];

                if (i == j) {
                    xy += board[i][j];
                }
                if (i == idx && j == 4 - idx) {
                    yx += board[i][j];
                    idx++;
                }
            }
            if(row == 0) {
                bingo_count++;
            }
            if(col == 0) {
                bingo_count++;
            }
        }
        if(xy == 0) {
            bingo_count++;
        }
        if(yx == 0) {
            bingo_count++;
        }
    }
    public int bingo(int[][] board, int[] host) {
        int count = 0;
        // 1. 현재 사회자가 부른 값을, 철수가 적은 빙고판에서 체크해야한다 -> 반복문을 사용
        for (int i = 0; i < 25; i++) {
            boolean find = false;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if(host[i] == board[x][y]){ // 사회자가 부른 숫자와 동일한 빙고판 숫자는 0으로 바꾼다.
                        board[x][y] = 0;
                        count++;
                        find = true; // 사회자와 동일한 숫자 발견 시 반복문 종료하는 falg
                        break;
                    }
                }
                if(find) break;
            }
            if(count >= 12) {
                // 최소 12번 후 부터 빙고인지 확인하는 메소드 실행
                check(board);
            }
            if(bingo_count >= 3) break;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        boj_2578 T = new boj_2578();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
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
            for (int j = 0; j < 5; j++) {
                host[idx++] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(T.bingo(board, host));
    }
}
