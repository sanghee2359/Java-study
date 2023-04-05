package ps.stack;
// 여러 개의 쇠막대기를 레이저로 절단하려고 한다.
// 쇠막대기는 자신보다 긴 막대 위에 놓을 수 있다. 단, 하단의 막대의 범위를 벗어나면 안되고, 끝점도 겹치면 안된다.

// 조건 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현
// 조건 2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현

import java.util.Scanner;
import java.util.Stack;

// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때,
// 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램
public class IronRod {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='(') stack.push('(');
            else {
                stack.pop();
                if(str.charAt(i-1)=='(') answer+= stack.size();
                else answer++;
        }
//            System.out.printf(x+" ");
//            if(x == ')') {
//                if(stack.peek() == '(') { // -> 레이저 확인
//                    stack.pop(); // pop한 후 스택에 남은 '('는 모두 쇠막대에 해당
//                    answer += stack.size();
//                } else if(stack.peek() == ')'){ // -> 쇠막대기 종료
//                    stack.pop();
//                    answer += 1;
//                }
//            } else if(x == '(') stack.push(x);
        }

        return answer;
    }
    public static void main(String[] args) {
        IronRod T = new IronRod();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
