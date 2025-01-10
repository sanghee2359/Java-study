package inflearn.sorting;

import java.util.Arrays;
import java.util.Collections;

public class TakeTheCard {
    public int solution(int[] nums, int k){
        int answer = 0, n = nums.length;
        Integer[] tmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (a, b)-> b - a); // 내림차순 정렬
        Integer[] diff = new Integer[n/2];
        for (int i = 0; i < n/2; i++) {
            answer += tmp[i * 2 + 1]; // 우선권이 없는 현수는 홀수 인덱스 값을 고름(더 작은 값)
            diff[i] = tmp[i*2] - tmp[i*2+1]; // 편차를 저장
        }
        Arrays.sort(diff, (a, b)-> b - a);
        // 현수가 우선권을 사용하지 않았을 때 점수
        // + k번만큼 우선권을 쓰고 얻은 점수 차 = 얻을 수 있는 최고점수

        for(int i = 0; i < k; i++) {
                answer += diff[i];
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
