package inflearn.sorting;
import java.util.*;
public class BinarySorting {
    public int oneInBinary(int num) {
        int count = 0;
        // toBinaryString 같은거 말고, 직접 tmp%2 로 나머지를 구해서 값을 찾아나간다
        while(num > 0) {
            count += (num % 2); // 나머지는 0또는 1일 것. 누적 합이 결국 1의 개수가 된다.
            num /= 2;
        }
        return count;
    }
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        int[][] result = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            result[i][0] = nums[i];
            result[i][1] = oneInBinary(nums[i]);// 이진수 개수의 값.
        }
        Arrays.sort(result, (a, b)-> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < nums.length; i++) {
            answer[i] = result[i][0];
        }
        return answer;
    }

    public static void main(String[] args){
        BinarySorting T = new BinarySorting();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }

}
