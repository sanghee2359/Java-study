package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num-i; j++) {
                System.out.print(" ");
            }
            for (int j = num-i; j < num ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
