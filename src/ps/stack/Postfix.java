package ps.stack;
// 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램
// * 후위연산식 = 연산자가 피연산자 뒤에 있는 표기식
// * 스택은 first in, last out
import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x))stack.push(x-48);
            else{
                int last = stack.pop();
                int first = stack.pop();
                if(x=='+') stack.push(first+last);
                else if(x=='-') stack.push(first-last);
                else if(x=='/') stack.push(first/last);
                else if(x=='*') stack.push(first*last);
            }
        }
        answer = stack.pop();
        return answer;
    }
    public static void main(String[] args) {
        Postfix T = new Postfix();
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
