package inflearn.Implementation;
import java.util.*;

public class LadderClimbing {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        int[] mid_answer = new int[n];
        for (int i = 1; i <= n; i++) {
            int k = i;
            for (int j = 0; j < ladder.length; j++) {
                // ladder의 첫번째 가로줄과 겹치는 경우
                for (int l = 0; l < ladder[j].length; l++) {
                    if (k == ladder[j][l]) {
                        k++;
                        break;
                    }
                    if (k == ladder[j][l] + 1) {
                        k--;
                        break;
                    }
                }
            }
            mid_answer[i-1] = k;

        }
        int idx = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            if(idx == n) break;
            answer[mid_answer[idx++] - 1] = (char) i;
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
