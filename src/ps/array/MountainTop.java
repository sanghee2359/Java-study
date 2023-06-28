package ps.array;

import java.util.Arrays;
import java.util.Scanner;
// 봉우리 지역이 몇 개 있는지 알아내는 프로그램
// 각 격자ㅏㄴ의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자 = 봉우리지역
public class MountainTop {
    public static void main(String[] args) {
        MountainTop T = new MountainTop();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] area = new int[n+2][n+2];
        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < n+2; j++) {
                if(i==0||j==0||i==n+1||j==n+1) area[i][j] = 0;
                else{area[i][j] = sc.nextInt();}
            }
        } // input

        System.out.println(T.solution(n, area));
    }
    private int solution(int n, int[][] area) {
        int answer = 0;
        n = area.length;
        int[] compare = new int[4];
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                compare[0] = area[i-1][j];
                compare[1] = area[i+1][j];
                compare[2] = area[i][j-1];
                compare[3] = area[i][j+1];
                Arrays.sort(compare);
                if(compare[3] < area[i][j]) answer++;
                else continue;
            }
        }

        return answer;
    }
}