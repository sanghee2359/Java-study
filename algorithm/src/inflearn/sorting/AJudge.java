package inflearn.sorting;

import java.util.Arrays;

public class AJudge {
    static Integer[] res;
    public int average(int k, int i, int j) {
        int sum = 0;
        for (int l = i; l <= j; l++) {
            sum += res[l];
        }
        return sum / k;
    }

    public int solution(int[] score, int k){
        int answer = 0, n = score.length;
        boolean flag = false;
        res = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < n; i++) { // o 인덱스부터 시작
            if(flag) break;
            for (int j = n-1; j > i; j--) { // score j가 큰 값
                if(j-i +1 == k && res[j] - res[i] <= 10){
                    answer = average(k, i, j);
                    flag = true;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        AJudge T = new AJudge();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
