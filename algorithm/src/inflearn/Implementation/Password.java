package inflearn.Implementation;

import java.util.Arrays;

// 1. 상하좌우 & 대각선에 위치한 키패드로 이동하는 시간 1초
// 2. 그렇지 않은 경우 2초 소요
// 3. 현재 키패드의 숫자에 패스워드를 입력했을 때 걸리는 시간을 출력
public class Password {
    public int solution(int[] keypad, String password){
        int answer = 0;
        int[][] pad = new int[3][3];
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] dist = new int[10][10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            dist[i][0] = 0;
            dist[0][i] = 0;
            dist[i][i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cur = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                        int next = pad[nx][ny];
                        dist[cur][next] = 1;
                    }
                }
            }
        }
        for(int i = 1; i < password.length(); i++){
            int cur = (int) password.charAt(i-1) - 48; // 이전 키
            int next = (int) password.charAt(i) - 48; // 다음 키
            System.out.println(cur+" "+next);
            answer += dist[cur][next];
        }
        return answer;
    }

    public static void main(String[] args){
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
