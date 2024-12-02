package inflearn.Implementation;
import java.util.*;
public class MaxLengthBitonic {
    // 최대 길이 바이토닉 수열 -> 연속부분수열 중 가장 긴 바이토닉 수열 찾기
    public int solution(int[] nums){
        int answer = 0;
        // 1. 봉우리가 되는 지점 찾기
        ArrayList<Integer> peak = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peak.add(i);
            }
        }
        for (int x : peak) {
            int left = x, right = x;
            int count = 1;
            // i인덱스의 왼쪽
            while( left - 1 >= 0 && nums[left] > nums[left -1]) {
                count++;
                left--;
            }
            while( right+1 < nums.length && nums[right] > nums[right+1])  {
                count++;
                right++;
            }
            answer = Math.max(count, answer);
        }
        return answer;
    }

    public static void main(String[] args){
        MaxLengthBitonic T = new MaxLengthBitonic();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
