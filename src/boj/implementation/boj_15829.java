package boj.implementation;

import java.util.Scanner;

public class boj_15829 {
    // 해시 함수는 무궁무진한 응용 분야를 갖는데, 대표적으로 자료의 저장과 탐색에 쓰인다.
    // 항의 번호에 해당하는 만큼 특정한 숫자를 거듭제곱해서 곱해준 다음 더하는 것
    // r(특정한 숫자)의 거듭제곱
    public long hashing(char[] input) {
        long answer = 0, square = 0;
        int num = 0, r = 31, n = input.length;
        for (int i = 0; i < n; i++) {
            num = input[i] - 96;
            square = 1;
            // r을 i제곱수만큼 = i개수만큼 r을 곱한다
            for (int j = 0; j < i; j++) {
                square *= r;
            }
            answer += (num * square);
        }
        return answer;
    }
    public static void main(String[] args) {
        boj_15829 T = new boj_15829();
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();
        char[] input = new char[L];
        for (int i = 0; i < L; i++) {
            input[i] = str.charAt(i);
        }
        System.out.println(T.hashing(input));


    }
}
