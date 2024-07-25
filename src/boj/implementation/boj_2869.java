package boj.implementation;

import java.util.Scanner;

public class boj_2869 {
    public static int solve(int up, int down, int length) {
        int day = (length - down) / (up - down);
        if((length - down) % (up - down) != 0) {
            day++;
        }
        return day;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        System.out.println(solve(A, B, V));
    }
}
