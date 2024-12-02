package inflearn.Implementation;
import java.util.*;
public class SeatNumber {
    public int[] solution(int c, int r, int k){ // c * r = 강연장 크기, k번 째에 온 사람이 착석할 위치
        int[] answer = {0, 0};
        if(c * r < k) {
            return answer;
        }
        boolean [][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = false;
            }
        }
        // 시작 위치 : 제일 왼쪽 & 제일 아래
        // x좌표? r-1, y좌표 0
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 0, count = 1;
        while(count <= c * r) {
            if(count == k) {
                break;
            }
            visited[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= r || ny < 0 || ny >= c
                    || visited[nx][ny] ) {
                d = (d + 1) % 4;
                continue;
            }
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = y+1;
        answer[1] = x+1;
        return answer;
    }

    public static void main(String[] args){
        SeatNumber T = new SeatNumber();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}