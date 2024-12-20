package inflearn.hashing;

import java.util.HashMap;

public class SubsequenceWithNegativeNumbers {
    // 연속부분수열의 합이 특정숫자 이 되는 경우가 몇 번있는지 구하는 프로그램
    // 제한사항 nums의 길이는 200,000 넘지 않는다.
    // -100,000,000 <= M <= 100,000,000
    // 수열의 원소값은 각 -1000 ~ 1000의 정수
    // 즉, 시간복잡도를 신경써야겠다 -> 무작정 for문 반복은 안됨
    public int solution(int[] nums, int m){
        // 음수가 있는 부분수열을 구할 때는 투포인트 알고리즘으로 풀이할 수 없다.
        // 0번째 인덱스부터 더한 누적합 sum을 key
        // 그것의 빈도수가 value인
        // 해싱을 사용
        HashMap<Integer, Integer> hashing = new HashMap<>();
        hashing.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hashing.containsKey(sum-m)) { // sum - m 값이 key로 존재한다면
                count += hashing.get(sum-m); // 그 나머지는 m 값과 동일하다는 의미 -> 빈도수 결합
            }
            hashing.put(sum, hashing.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args){
        SubsequenceWithNegativeNumbers T = new SubsequenceWithNegativeNumbers();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
