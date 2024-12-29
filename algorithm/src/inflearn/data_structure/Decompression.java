package inflearn.data_structure;

import java.util.Stack;

public class Decompression {
    public String solution(String s){
        String answer = "";
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c != ')') {
                stack.push(Character.toString(c));
                continue;
            }
            while(!stack.peek().equals("(")) { // 열린 괄호가 나올 때까지 반복
                String tmp = stack.pop();
                sb.insert(0, tmp);
            }
            stack.pop(); // 괄호 제거
            int num = Integer.parseInt(stack.pop());
            for (int i = 0; i < num - 1; i++) {
                sb.append(sb);
            }
            stack.push(sb.toString());
        }
        while(stack.isEmpty()) {
            answer += stack.pop();
        }
        answer = answer + sb.toString();
        return answer;
    }

    public static void main(String[] args){
        Decompression T = new Decompression();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }

}
