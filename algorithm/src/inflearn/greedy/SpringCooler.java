package inflearn.greedy;

import java.util.Arrays;

public class SpringCooler {
    public int solution(int n, int[] nums){
        int answer = 0;
        int[][] line = new int[n+1][2]; // 스프링 쿨러는 n+1개
        for (int i = 0; i < n+1; i++) {
            line[i][0] = Math.max((i - nums[i]), 0);
            line[i][1] = Math.min((i + nums[i]), n); // 최대 범위를 넘어가지 않도록
        }
        Arrays.sort(line, (a, b)-> a[0] - b[0]); // 시작값 기준 오름차순
        int start = 0, end = 0, i =0;
        while(i < line.length){
            while(i < line.length && line[i][0] <= start) {
                end = Math.max(line[i][1], end); 
                i++; // start 지점부터 가장 길게 물을 뿌리는 스프링 쿨러를 찾는 while문
            }
            answer++;
            if(end == n) return answer; // 물을 다 뿌림
            if(start == end) return -1;
            start = end;
        }
        return answer;
    }

    public static void main(String[] args){
        SpringCooler T = new SpringCooler();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}

