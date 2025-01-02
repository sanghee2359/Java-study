package inflearn.data_structure;

import java.util.Stack;

public class Decompression {
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            // 닫힌 괄호가 나올 때

            if (x == ')') {
                String tmp = "";
                while (!stack.empty()) {
                    String cur = stack.pop();
                    if (cur.equals("(")) { // 현재 pop한 값이 열린괄호일 때
                        String num = "";
                        // stack의 가장 위에 있는 문자열이 숫자형 문자열인지 확인
                        while (!stack.empty() && Character.isDigit(stack.peek().charAt(0))) { // 숫자가 나올 때까지
                            num += stack.pop();
                        }
                        String result = "";
                        int count = 0;
                        if(num.equals("")) count = 1; // 스택에 숫자형 문자열이 없었을 경우 -> 1회 빈도수
                        else count = Integer.parseInt(num);
                        for (int i = 0; i < count; i++) result += tmp;
                        stack.push(result); // 괄호를 벗긴 후 다시 stack에 저장
                        break;
                    }
                    tmp = cur + tmp; // 여는 괄호가 아닐 경우 더하기
                }

            }else stack.push(String.valueOf(x));

        }
        for (String x : stack) answer += x;
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
