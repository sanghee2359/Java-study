package inflearn.sorting;

import java.util.Arrays;

public class AJudge {
    static Integer[] res;
    public int average(int[] score, int s, int e) {
        int sum = 0;
        for (int i = s; i <= e; i++) {
            sum += score[i];
        }
        return (int)Math.floor((sum / (e - s +1) ));
    }

    public int solution(int[] score, int k){
        int n = score.length;
        Arrays.sort(score);
        // k 슬라이딩 윈도우 크기
        // 최대값 - 최소값을 구할 수 있는 최대한은 n - k
        for (int i = 0; i < n - k; i++) {
            // 최댓값 - 최소값
            if(score[i + k - 1] - score[i] <= 10) {
                return average(score, i, i + k - 1);
            }
        }
        return 0 ;
    }

    public static void main(String[] args){
        AJudge T = new AJudge();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
