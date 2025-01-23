package inflearn.greedy;

import java.util.*;


public class NumberOfMoves {
    // 가장 5kg에 가까운 수를 만들기(더하거나 그 자체인 )
    // 5,4,3,3,2,2
    // 5,4,3,2
    public int solution(int[] nums){
        int answer = 0, n = nums.length;
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬
        int lt = 0, rt = n - 1;
        while(lt <= rt) {
            if(arr[lt]+arr[rt] > 5 && arr[lt] <= 5) {
                answer++;
                lt++;
            }else {
                answer++;
                lt++;
                rt--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        NumberOfMoves T = new NumberOfMoves();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }

}
