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
        for (int i = 0; i < arrival[num - 1]; i++) {
            while(arrival[++i] == i) {
                if(arrival[i] == i && state[i] == 0) {
                    enter.add(i);
                }
                else if(arrival[i] == i && state[i] == 1){
                    exit.add(i);
                }
            }

            if(prev == 1) {
                Integer employeeNum = exit.poll();
                answer[employeeNum] = i;
            }else if(exit.isEmpty()) {
                Integer employeeNum = enter.poll();
                answer[employeeNum] = i;
                prev = 0;
            }else {
                Integer employeeNum = enter.poll();
                answer[employeeNum] = i;
            }

        }
            // 1. 1초 전에 사용한 적 없다면 arrival[i]-1 이 큐에 없으면
            // state[i] = 1 (나가는 사람) 먼저 현관 이용
            // 2-1. 1초 전에 state[i] = 1(나가는 사람)이 이용했다면
            // 겹치는 경우 나가는 사원 먼저 사용

            // 2-2. 1초 전에 state[i] = 0(들어오는 사람)이 이용했다면
            // 겹치는 경우 들어오는 사원 먼저 이용
            // 3. 같은 방향이고, 값이 같아면 i(사원번호)가 낮은 사람먼저

        return answer;
    }


    public static void main(String[] args){
        OrderOfEntry T = new OrderOfEntry();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
