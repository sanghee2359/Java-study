package inflearn.data_structure;
import java.util.*;
public class SJFScheduling {
    public int[] solution(int[][] tasks){
        int n = tasks.length, endTime = 0, order = 0;
        int[] answer = new int[n];
        PriorityQueue<Task> readyQ = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.taskTime - o2.taskTime;
            }
        });
        ArrayList<Task> sort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sort.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(sort);
        Task first = sort.get(0);
        readyQ.offer(first);
        endTime = first.arrivalTime; // 초기화
        for (int i = 1, t = endTime; ; t++) { // i는 arrayList의 배열 인덱스
            // 도착시간이 작업이 끝나기 전까지의 시간보다 작거나 같다면 큐에 저장
            while(i < n && sort.get(i).arrivalTime <= endTime) {
                readyQ.offer(sort.get(i));
                i++;
            }
            if(endTime == t && !readyQ.isEmpty()){
                // answer에 저장
                Task cur = readyQ.poll();
                answer[order++] = cur.num; // order은 작업 순서 인덱스
                endTime = endTime + cur.taskTime;
            }
            if(readyQ.isEmpty() && endTime < sort.get(i).arrivalTime) {
                t = endTime = sort.get(i).arrivalTime;
                readyQ.offer(sort.get(i++));
            }

            if(order == n - 1) return answer;
        }
    }

    public static void main(String[] args){
        SJFScheduling T = new SJFScheduling();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
class Task implements Comparable<Task> {
    int num;
    int arrivalTime;
    int taskTime;
    public Task(int num,int arrivalTime, int taskTime) {
        this.num = num;
        this.arrivalTime = arrivalTime;
        this.taskTime = taskTime;
    }
    @Override
    public int compareTo(Task o) {
        return this.arrivalTime - o.arrivalTime;
    }
}