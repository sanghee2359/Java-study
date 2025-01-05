package inflearn.data_structure;
import java.util.*;
public class SJFScheduling {
    public int[] solution(int[][] tasks) {
        int n = tasks.length, endTime = 0, order = 0;
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<int[]> programs = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            programs.add(new int[]{tasks[i][0], tasks[i][1], i}); // 도착시간, 작업시간, 작업 번호
        }
        // 호출 시간에서 오름차순 정렬
        programs.sort((a, b)-> a[0] - b[0]);
        // 도착시간이 같다면, 작업시간 기준으로 정렬
        PriorityQueue<int[]> readyQ = new PriorityQueue<>((a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        while(!programs.isEmpty() || !readyQ.isEmpty()) {
            if(readyQ.isEmpty()) endTime = Math.max(endTime, programs.peek()[0]); // 도착시간
            // 작업해야 할 프로그램이 남아있고, 도착시간이 현재 작업이 끝날 시간보다 작거나 같다면
            while(!programs.isEmpty() && programs.peek()[0] <= endTime) {
                int[] addQueue = programs.pollFirst(); // 아마도 값을 넣어주는 듯?
                readyQ.add(new int[]{addQueue[1], addQueue[2]}); // 작업 시간, 작업 번호
            }
            int[] processing = readyQ.poll(); // 처리할 작업
            result.add(processing[1]); // 결과에 현재 작업 번호 추가
            endTime = endTime + processing[0]; // 이 작업이 작업이 끝나는 시간 업데이트
        }
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) answer[i] = result.get(i);
        
        return answer;
    }

    public static void main(String[] args){
        SJFScheduling T = new SJFScheduling();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}