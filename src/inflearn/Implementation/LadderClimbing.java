package inflearn.Implementation;
import java.util.*;

public class LadderClimbing {
    public int[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        int[] mid_answer = new int[n];
        for (int i = 1; i <= n; i++) {
            int k = i;
            for (int j = 0; j < ladder.length; j++) {
                // ladder의 첫번째 가로줄과 겹치는 경우
                    if(k == ladder[j][0]) k++;
                    else if( k == ladder[j][0]+1) k--;

            }
            System.out.println(k);
        }

//        return answer;
        return mid_answer;
    }

    public static void main(String[] args){
        LadderClimbing T = new LadderClimbing();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
//        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
//        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
//        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

}
