package ps.stack;


import java.util.Scanner;
import java.util.Stack;

// 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
// 괄호 쌍이 맞도록 문자열을 나열했는지 판별하는 프로그램
public class CorrectParentheses {
    public String solution(String str) {
        String answer="YES";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else {
                // 닫는 괄호를 만났는데, 여는 괄호가 없는경우
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
            System.out.println("스택 크기:"+stack.size());
        }
        // 더 이상 닫는 괄호가 없는데, 여는 괄호가 남아있을 경우
        if(!stack.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        CorrectParentheses T = new CorrectParentheses();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
