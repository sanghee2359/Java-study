package inflearn.sorting;
import java.util.*;
public class SearchForSequence {
    // ArrayList 자료구조 활용
    public int[] solution(int[] nums){
        long startTime = System.nanoTime();
        int[] answer = new int[nums.length / 2];
        ArrayList<Integer> numList = new ArrayList<>();
        for(int x : nums) {
            numList.add(x);
        }
        int idx = 0;
        for(int x : numList){
            if(!numList.contains(x * 2)) continue;
            answer[idx++] = x;
        }
        Arrays.sort(answer);
        long endTime = System.nanoTime(); // 끝 시간 측정
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");

        return answer;
    }

    public static void main(String[] args){
        SearchForSequence T = new SearchForSequence();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
