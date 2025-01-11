package inflearn.sorting;

import java.util.Arrays;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int res = tasks.length;
        int[] sT = new int[res+1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);
        // st에서 i를 통해 반복문 시작
        for (int i = 1; i < sT.length; i++) {
            long time = ((long) res *(sT[i] - sT[i-1]));
            if(k < time) {
                long idx = k % res; // 남은 작업시간을 남은 작업들의 나머지로 구함
                int count = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if(tasks[j] >= sT[i]) { // 아직 작업이 남은 것만
                        if(count == idx) return j+1;
                        count++; // 남은 k시간 만큼 작업 수행
                    }
                }
            }else {
                k = k - time;
                res--;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MultiTasking T = new MultiTasking();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
