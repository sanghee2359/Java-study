package inflearn.data_structure;

import java.util.*;

public class MaxLengthContinuousSequence {
    // 1씩 증가하는 연속된 수열의 최대 길이
    // nums의 길이가 300,000 이하 -> 효율성 테스트
    //
    public int solution(int[] nums){
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        for (int x : set) {
            if(set.contains(x - 1)) continue;
            int count = 0;
            while(set.contains(x)) {
                count++;
                x++;
            }
            answer = Math.max(answer, count);
        }
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
