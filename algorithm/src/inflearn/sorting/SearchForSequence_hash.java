package inflearn.sorting;
import java.util.*;
public class SearchForSequence_hash {
    // HashMap 자료구조 활용 (수열 안에 중복되는 숫자도 함께 관리)
    public int[] solution(int[] nums){
        long startTime = System.nanoTime();
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums); // 오름차순 정렬
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int idx = 0;
        for (int x : nums) {
            if(map.get(x) == 0) continue;
            answer[idx++] = x;
            map.put(x, map.get(x) - 1);
            map.put(x * 2, map.get(x * 2) - 1);

        }
        long endTime = System.nanoTime(); // 끝 시간 측정
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");

        return answer;
    }

    public static void main(String[] args){
        SearchForSequence_hash T = new SearchForSequence_hash();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
