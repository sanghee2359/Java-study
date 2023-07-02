package ps.string;

import java.util.Scanner;
// 임의의 문자열 str로 회문을 만들기
// 문자열 str 뒤에 0개 이상의 숫자를 추가해 회문을 생성하고, 가장 짧은 회문의 길이를 출력
public class PalindromeString {
    public static void main(String[] args) {
        PalindromeString T = new PalindromeString();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

    private int solution(String str) {
        // 회문 문자열을 만들고 그 문자열의 길이를 출력하는 프로그램
        for (int i = str.length();; i++) {
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if((i-j-1) <str.length()
                        && str.charAt(j)!= str.charAt(i-j-1)) {
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
    }
}
