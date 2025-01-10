package inflearn.sorting;

import java.util.Arrays;
import java.util.Collections;

public class TakeTheCard {
    public int solution(int[] nums, int k){
        int answer = 0, n = nums.length;
        Arrays.sort(nums);
        int[][] result = new int[n][3];
        int idx = n-1;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = nums[idx--];
            }
            result[i][2] = result[i][0] - result[i][1];
        }
        Arrays.sort(result, (a, b) -> b[2] - a[2]);
        for(int[] x : result) {
            if(k > 0){
                answer+= x[0];
                k--;
                continue;
            }
            answer += x[1];
        }


        return answer;
    }

    public static void main(String[] args){
        TakeTheCard T = new TakeTheCard();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }

}
