package ps.string;

import java.util.Scanner;

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
