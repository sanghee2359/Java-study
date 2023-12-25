package ps.recursive;

import java.util.Scanner;

// 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
public class Fibonacci {
    static int[] fibo;
    public int DFS(int num) {
        if(fibo[num] > 0) return fibo[num];
        if(num == 1) return fibo[1] = 1;
        else if(num == 2) return fibo[2] = 1;
        else {
            return fibo[num] = DFS(num-1)+DFS(num-2);
        }

    }
    public static void main(String[] args) {
        Fibonacci O = new Fibonacci();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        fibo = new int[num+1];
        O.DFS(num);
        for (int i = 1; i <= num; i++) {
            System.out.printf(fibo[i]+ " ");
        }
    }
}
