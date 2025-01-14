package inflearn.greedy;

import java.util.Arrays;

public class Titanic {
    public int solution(int[] nums, int m){
        int answer = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            for (int j = n-1; j > i; j--) {
                if(nums[j] != 0 && nums[i] + nums[j] <= m)
                {
                    answer++;
                    nums[i] = 0;
                    nums[j] = 0;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        Titanic T = new Titanic();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
