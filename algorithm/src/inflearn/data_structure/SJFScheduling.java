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
        endTime = first.arrivalTime + first.taskTime;
        for (int i = 1, t = endTime; ; i++) {
            if(endTime == t && !readyQ.isEmpty()){
                // answer에 저장
                Task cur = readyQ.poll();
                answer[cur.num] = order++;
                endTime = endTime + cur.taskTime;
            }
            while(i < n && sort.get(i).arrivalTime <= t) {
                readyQ.offer(sort.get(i));
                i++;
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

    /**
     *
     * 도착 시간을 기준으로 정렬하고, 같다면 작업시간 순으로 정렬
     * @return
     */

    @Override
    public int compareTo(Task o) {
        int r = this.arrivalTime - o.arrivalTime;
        if(r == 0) {
            r = this.taskTime - o.taskTime;
        }
        return r;
    }
}