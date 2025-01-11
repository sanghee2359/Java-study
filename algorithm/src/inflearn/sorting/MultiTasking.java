package inflearn.sorting;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int idx = 0, n = tasks.length;
        long time = k;
        tasks[idx]--;
        time--;
        while(time != 0) {
            idx = (idx + 1) % n; // 다음 작업 인덱스로 이동
            if(tasks[idx] == 0) continue;
            tasks[idx]--;
            time--;
        }
        // 마지막으로 한 작업의 다음으로 해야할 작업을 반환
        idx = (idx + 1) % n;
        if(tasks[idx] != 0) return idx;
        // 바로 다음 작업이 완료되어 0일 경우
        while(tasks[idx] == 0) {
            idx = (idx + 1) %n;
            if(tasks[idx] != 0) return idx;
        }
        return idx;
//        return answer;
    }

    public static void main(String[] args){
        MultiTasking T = new MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
