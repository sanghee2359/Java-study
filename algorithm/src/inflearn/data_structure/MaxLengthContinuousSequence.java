package inflearn.data_structure;

import java.util.ArrayList;
import java.util.Collections;

public class MaxLengthContinuousSequence {
    // 1씩 증가하는 연속된 수열의 최대 길이
    public int solution(int[] nums){
        int answer = 0;
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
        }
        Collections.sort(set);  // 정렬
        int sum = 1;            // 연속 수열의 길이 합
        for (int i = 0; i < set.size() - 1; i++) {
            if(set.get(i) + 1 == set.get(i+1)) {
                sum++;
            }
            else {
                answer = Math.max(sum, answer);
                sum = 1;
            }
        }
        answer = Math.max(sum, answer);
        return answer;
    }

    public static void main(String[] args){
        MaxLengthContinuousSequence T = new MaxLengthContinuousSequence();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
