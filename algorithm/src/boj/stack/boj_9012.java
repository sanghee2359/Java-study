package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 올바른 괄호 문자열(Valid PS, VPS) 만들기
public class boj_9012 {
    public static String solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);

            if(c == '(') {
                stack.push(c);
            }
            else if(stack.isEmpty()) {
                return "NO";
            }
            else stack.pop();

        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            System.out.println(solve(str));
        }
    }
}
