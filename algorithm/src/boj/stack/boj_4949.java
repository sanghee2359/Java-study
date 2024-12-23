package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4949 {
    private String solution(String str) {
        String answer = "yes";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '(') stack.push(str.charAt(i));
            else if (str.charAt(i) == ']')  {
                if(stack.empty() || stack.peek() != '[') return "no";
                stack.pop();
            }else if (str.charAt(i) == ')') {
                if(stack.empty() || stack.peek() != '(') return "no";
                stack.pop();
            }
        }
        if(!stack.empty()) return "no";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        boj_4949 T = new boj_4949();
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            if (line.equals(".")) break; // 종료 조건 명시
            sb.append(T.solution(line)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
