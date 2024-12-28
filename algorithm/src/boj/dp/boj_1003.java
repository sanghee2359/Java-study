package boj.dp;

import java.util.Scanner;

public class boj_1003 {
    public static Integer[][] fibo;
    private Integer[] solution(int num){
        if(fibo[num][0] == null || fibo[num][1] == null) {
            fibo[num][0] = solution(num - 1)[0] + solution(num - 2)[0];
            fibo[num][1] = solution(num - 1)[1] + solution(num - 2)[1];
        }
        return fibo[num];
    }
    public static void main(String[] args) {
        boj_1003 T = new boj_1003();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        fibo = new Integer[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            T.solution(num);
            sb.append(fibo[num][0]).append(" ").append(fibo[num][1]).append("\n");
        }
        System.out.println(sb);
    }
}
