package boj.implementation;

import java.util.Scanner;
// 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
// N번째 영화의 제목에 들어간 수를 출력하는 프로그램
//  N은 10,000보다 작거나 같은 자연수이다.

public class boj_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N > 1) {
            func(N);
        }else System.out.println(666);
   }
   public static void func(int n) {
        int count = 1;
        int pre_digit = 0; // 선수 자릿수
        int num = 0; // 이외의 자릿수
       // ex 6660_xxx
       while(true) {
           if(((pre_digit % 10000) / 10)== 666
                   && pre_digit % 10 != 6){
               for (int i = 0; i < 1000; i++) {
                   if(count == n) {
                       System.out.println(pre_digit* 1000 + num);
                       return;
                   }
                   num++;
                   count++;
               }
               pre_digit++;

           } // 666_xxx
           else if((pre_digit % 1000) == 666) {
               num = 0;
               for (int i = 0; i < 1000; i++) {
                   if(count == n) {
                       System.out.println((pre_digit* 1000) + num);
                       return;
                   }
                   num++;
                   count++;
               }
               pre_digit++;
           } // 66_6xx
           else if(pre_digit % 100 == 66){
               num = 600;
               for (int i = 0; i < 100; i++) {
                   if(count == n) {
                       System.out.println((pre_digit * 1000) + num);
                       return;
                   }
                   num++;
                   count++;
               }
               pre_digit++;
           }
           // 6_66x
           else if(pre_digit % 10 == 6) {
               num = 660;
               for (int i = 0; i < 10; i++) {
                   if(count == n) {
                       System.out.println((pre_digit*1000) + num);
                       return;
                   }num++;
                   count++;
               }
               pre_digit++;
           }
           // xx_ 666
           else {
               num = 666;
               if(count == n) {
                   System.out.println(pre_digit * 1000 + num );
                   return;
               }
               count++;
               pre_digit++;
           }
       }
   }
}
