package ps.string;
// 비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성
// 1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다.
// 2. 바뀐 이진수를 10진수화 한다.

import java.util.Arrays;
import java.util.Scanner;

// 현수가 4개의 문자를 다음과 같이 신호로 보냈다면
// #****###**#####**#####**##**
// COOL로 해석된다.
// 현수가 보낸 신호를 해석해주는 프로그램 작성
public class Password {
    public static void main(String[] args) {
        Password T = new Password();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String pw = sc.next();
        System.out.println(T.solution(num, pw));
//        for(char x : T.solution(num, pw)){
//            System.out.print(x);
//        }
    }

    private char[] solution(int num, String pw) {
        char[] answer = new char[num];
        int[] divide = new int[num];
        // 먼저 대체하고 보자
        pw = pw.replaceAll("[*]","0");
        pw = pw.replaceAll("[#]","1");
        // 분해 및 2진수 만들기
        for (int i = 0; i < num-1; i++) {
            divide[i] = Integer.parseInt(pw.substring(0,7), 2); // 2진수 만들기
            pw = pw.substring(7);
        }
        // 마지막 2진수 저장
        divide[num-1] = Integer.parseInt(pw, 2);

        // 문자열 저장
        for (int i = 0; i < num; i++) {
            answer[i] = (char)divide[i];
        }

        return answer;
    }
}
