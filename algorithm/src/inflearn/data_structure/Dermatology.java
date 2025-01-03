package inflearn.data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class Dermatology {
    private int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M;
    }
    public int solution(int[] laser, String[] enter){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        Queue<Integer> waiting = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            int time = getTime(enter[i].split(" ")[0]);
            int laserOp = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = time;
            inList[i][1] = laserOp;
        }
        waiting.offer(inList[0][1]); // 첫번째 시술 시작
        int endTime = inList[0][0]; // 수술이 각각 끝나는 시간을 저장
        int pos = 1;
        for (int t = endTime; t <= 1200; t++) {  // 20:00 까지만 피부과 운영
            if(pos < n && t == inList[pos][0]) { // 고객이 도착하면
                if(waiting.isEmpty() && inList[pos][0] > endTime) endTime = inList[pos][0]; // 만약 대기 줄이 없었다면 바로 시술
                waiting.offer(inList[pos][1]); // 현재 수술중인 고객이 끝날때까지 대기 큐에 저장
                pos++;
            }
            if(t == endTime && !waiting.isEmpty()) {
                int idx = waiting.poll(); // 시술이 끝나며, 대기줄의 다음 고객의 수술 진행
                endTime += laser[idx];
            }
            answer = Math.max(answer, waiting.size());
        }
        return answer;
    }

    public static void main(String[] args){
        Dermatology T = new Dermatology();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
