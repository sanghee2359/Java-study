package inflearn.data_structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OrderOfEntry {
    public int[] solution(int[] arrival, int[] state){
        int num = arrival.length, prev = 1; // 이전 사원의 출입 유무 저장
        int[] answer = new int[num];
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        for (int i = 0, t = 0, count = 0;; t++) {
            if (i < num && enter.isEmpty() && exit.isEmpty()) {
                if(t < arrival[i]){
                    t = arrival[i]; // 건너 뛰기
                    prev = 1;
                }
            }
            // t와 같은 시간에 도착한 i 사원들을 모두 큐에 저장
            while (i < num && arrival[i] <= t) { // 종료 조건
                if (state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }
            if (prev == 1) { // 현재 나가는 사람 우선 조건일 경우
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                } else { // exit 대기 줄이 비어있으면 enter에서 현관문 이용
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            count++;
            if (count == num) return answer;
        }
    }


    public static void main(String[] args){
        OrderOfEntry T = new OrderOfEntry();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
