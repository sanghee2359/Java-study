package ps.array;

import java.util.Arrays;
import java.util.Scanner;
// 봉우리 지역이 몇 개 있는지 알아내는 프로그램
// 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자 = 봉우리지역
public class MountainTop {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        MountainTop T = new MountainTop();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] area = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = sc.nextInt();
            }
        } // input
        System.out.println(T.solution(n, area));
    }
    private int solution(int n, int[][] area) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx >= 0 && nx < n && ny >=0 && ny < n &&
                            area[nx][ny] >= area[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
}