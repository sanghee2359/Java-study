package inflearn.Implementation;
import java.util.*;
public class FindingADog {
    public int solution(int[][] board){ // 항상 10 * 10
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, idx = 0, time = 0;
        // 현수의 위치 찾기
        for (int i = 0; i < 10; i++) {
            Integer[] tmp = Arrays.stream(board[i]).boxed().toArray(Integer[]::new);
            int check = Arrays.asList(tmp).indexOf(2);
            if(check != -1) {
                x = check;
                y = i;
            }
        }
        System.out.println(x +" "+ y);

        while(board[x][y] != 3) {
            time++;
            int nx = x + dx[idx];
            int ny = y + dy[idx];
            if(nx >= 10 || nx < 0 || ny >= 10 || ny < 0
                    || board[nx][ny] == 1) {
                idx = (idx + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;

            if(time == 10000) {
                return 0;
            }
        }
        answer = time;

        return answer;
    }

    public static void main(String[] args){
        FindingADog T = new FindingADog();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}