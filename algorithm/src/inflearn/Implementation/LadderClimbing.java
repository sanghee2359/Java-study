package inflearn.Implementation;
import java.util.*;

public class LadderClimbing {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (char)(i+65);
        }
        // 모든 세로줄에서 아래로 하나씩 내려가면서
        for (int[] line : ladder) { // 가로줄을 만나면 이전의 알파벳과 교체
            for (int x:
                 line) {
                char tmp = answer[x];
                answer[x] = answer[x-1];
                answer[x-1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        LadderClimbing T = new LadderClimbing();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

}
