package ps.array;
// 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이
// 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고 한다.
// 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던
// 사람이 가장 많은 학생을 임시 반장으로 정하려 한다

// 각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
import java.util.Arrays;
import java.util.Scanner;

public class ChoosingClassLeader {
    public static void main(String[] args) {
        ChoosingClassLeader T = new ChoosingClassLeader();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, board));
    }

    private int solution(int n, int[][] board) {
        int answer = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) { // i는 학생을 의미
            int count = 0;
            for (int j = 1; j <= n; j++) { // j는 학년을 의미
                for (int k = 1; k <= 5; k++) {
                    if(board[i][k] == board[j][k]){
                        count++;
                        break;
                    }
                }
            }
            if(max < count) {
                max = count;
                answer = i; // 최대값을 만드는 학생
            }
        }
        return answer;
    }
}
