package boj.dp;

import java.util.Scanner;

public class boj_1003 {
    public static int zeroCount;
    public static int oneCount;
    private int solution(int num){
        if(num == 0) {
            zeroCount++;
            return 0;
        }
        else if (num == 1) {
            oneCount++;
            return 1;
        }
        else {
            return solution(num - 1) + solution(num -2);
        }
    }
    public static void main(String[] args) {
        boj_1003 T = new boj_1003();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            zeroCount = 0;
            oneCount = 0;
            int num = sc.nextInt();
            T.solution(num);
            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
        }
        System.out.println(sb);
    }
}
