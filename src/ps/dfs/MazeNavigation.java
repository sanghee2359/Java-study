package ps.dfs;

import java.util.Scanner;

public class MazeNavigation {
    static int[] dx = {1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;
    public void DFS(int x, int y) {
        if(x==7 && y ==7) answer ++;
        else {
            for (int i = 0; i <4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                DFS(nx, ny);
                board[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MazeNavigation O = new MazeNavigation();
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
    }
}
