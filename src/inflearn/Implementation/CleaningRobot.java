package inflearn.Implementation;
import java.util.*;
public class CleaningRobot {
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int N = board.length; // 5
        int x = 0; // 0
        int y = 0;
        int idx = 0;
        int ny = y + dy[idx]; // y가 x축
        int nx = x + dx[idx];
        while(k-->0) {
            if(idx < 4) {
                ny = y + dy[idx]; // y가 x축
                nx = x + dx[idx]; // x가 y축
                if(nx >= N || ny >= N
                        || nx < 0  || ny < 0
                        ||board[ny][nx] == 1) {
                    idx++;
                    continue;
                }
                x = nx;
                y = ny;
            }else idx = 0;
        }
        answer[0] = ny;
        answer[1] = nx;
        return answer;
    }

    public static void main(String[] args){
        CleaningRobot T = new CleaningRobot();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}