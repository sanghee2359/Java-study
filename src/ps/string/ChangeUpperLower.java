package ps.string;
// 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램
import java.util.Scanner;

public class ChangeUpperLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            // 대문자면 소문자로
            if(Character.isLowerCase(input.charAt(i))) {
                answer += Character.toUpperCase(input.charAt(i));
            // 소문자면 대문자로
            } else {
                answer += Character.toLowerCase(input.charAt(i));
            }
        }
        System.out.println(answer);
    }
}
