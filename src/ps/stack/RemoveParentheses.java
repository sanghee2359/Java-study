package ps.stack;
// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
        // 닫힌 괄호 만나면 여는 괄호를 만날 때까지 pop
            if(x ==')'){
                while(stack.pop()!='(');
            }
            else stack.push(x);
        }
        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        RemoveParentheses T = new RemoveParentheses();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
