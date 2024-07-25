package boj.input_output;

import java.util.Scanner;

public class boj_2869 {
    public static int solve(int A, int B, int V) {
        int sum = 0;
        int count = 0;
        while(sum < V) {
            count++;
            sum += A;
            if(sum >= V) break;
            sum -= B;

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        System.out.println(solve(A, B, V));
    }
}
