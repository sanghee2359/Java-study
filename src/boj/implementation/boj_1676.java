package boj.implementation;

import java.util.Scanner;

// N!을 계산한 뒤, 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램
public class boj_1676 {
    // 소인수 분해 했을 때 2*5 묶음의 개수가 곧 핵심인 것 같다
    // -> 항상 2는 5보다 더 많이 구성되어 있으므로, 5의 개수만 카운팅한다
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int two = 0;
        int five = 0;
        for (int i = 2; i <= N; i++) {
            int tmp = i;
            if(i%2 == 0) {
                while(tmp % 2 == 0) {
                 tmp = tmp/2;
                 two++;
             }
            }
            if(i%5 == 0) {
                while (tmp % 5 == 0) {
                    tmp /= 5;
                    five++;
                }
            }
        }
        if(two >= five) System.out.println(five);
        else  System.out.println(two);

    }
}
