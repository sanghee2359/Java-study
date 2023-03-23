package ps.stack;
// 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램

import java.util.Scanner;
import java.util.Stack;

public class RemoveParentheses {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        // 괄호가 열리면
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') stack.push('(');
            else if(str.charAt(i)==')') {
                while(stack.peek()=='('){
                    char cur = stack.peek();
                    System.out.println(cur);
                    stack.pop();
                }
            }
            else stack.push(str.charAt(i));
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.printf(stack.pop()+" ");
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
