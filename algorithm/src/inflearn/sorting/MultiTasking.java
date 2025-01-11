package inflearn.sorting;

import java.util.Arrays;

public class MultiTasking {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int res = tasks.length;
        int[] sT = new int[res+1];
        for (int i = 1; i < sT.length; i++) {
            sT[i] = tasks[i - 1];
        }
        Arrays.sort(sT);
        // st에서 i를 통해 반복문 시작
        for (int i = 1; i < sT.length; i++) {
            int repeat = sT[i] - sT[i-1];
            if(k - (long) res * repeat >= 0) {
                k = k - (long) res * repeat;
                res--; // 남은 작업 1 제외
                continue;
            }
            // 이제 3이 남았음 -> sT가 아닌, 실제 작업스케쥴러에서 1씩 시뮬레이션
            int idx = 0; // 작업스케쥴러 0번인덱스부터 작업 시뮬 시작
            while(k>0) {
                if(sT[i]> tasks[idx]) {
                    idx = (idx + 1) % tasks.length;
                    continue;
                }
                k--;
                idx = (idx+1) % tasks.length; // 다음 인덱스로 이동
            }
            return idx + 1;

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
