package inflearn.Implementation;
import java.util.*;
public class SeatNumber {
    public int[] solution(int c, int r, int k){ // c * r = 강연장 크기, k번 째에 온 사람이 착석할 위치
        int[] answer = {0, 0};
        if(c * r < k) {
            return answer;
        }
        // 90도 뒤집어서 계산
        int [][] seat = new int[c][r]; // 세로 c, 가로 r (변경됨)

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 0, count = 1;
        while(count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= c || ny < 0 || ny >= r
                    || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
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