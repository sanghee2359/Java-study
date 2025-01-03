package inflearn.data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class Dermatology {
    private int[] arrivalTimeCalculation(String[] enter) {
        int n = enter.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = enter[i].split("[ :]+");
            int hour = Integer.parseInt(tmp[0]);
            int minute = Integer.parseInt(tmp[1]);
            answer[i] = hour * 60 + minute;
        }
        return answer;
    }
    private int[] customerTreatmentOptions(String[] treatments) {
        int n = treatments.length;
        int[] options = new int[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = treatments[i].split(" ");  // 공백을 기준으로 분리
            options[i] = Integer.parseInt(tmp[1]);  // 두 번째 부분이 수술 옵션 (정수값으로 처리)
        }
        return options;
    }
    public int solution(int[] laser, String[] enter){
        int max = 0;
        int n = enter.length;
        int[] arrivalTime = arrivalTimeCalculation(enter);
        int[] treatments = customerTreatmentOptions(enter);
        int count = 0;
        Queue<Integer> waiting = new LinkedList<Integer>();
        waiting.offer(treatments[0]); // 첫 번째 손님
        for (int i = 0, t = 0; ; i++) {
            int arrival = 0, endTime = 0;
            if(!waiting.isEmpty()) {
                arrival = arrivalTime[i];
                endTime = arrival + laser[waiting.poll()]; // i 고객이 받을 laser 수술
            }else {
                endTime = endTime + treatments[i];
            }

            while(arrival != 0 && count < n && arrivalTime[count] < endTime ) { //i 1씩 증가 -> 시술이 끝나기 전에 도착한 손님들일 경우
                waiting.offer(treatments[count]); // 그 손님이 받을 수술 옵션을 waiting 큐에 저장
                count++;
            }
            max = Math.max(waiting.size(), max);
            if(count == n) return max;
        }
    }

    public static void main(String[] args){
        Dermatology T = new Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
