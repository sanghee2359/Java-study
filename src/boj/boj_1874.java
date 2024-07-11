package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class boj_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] v = new int[N+1];
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        // input end

        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        int idx = 0;
        int count = 1;

        while(count-1 <= N){ // count-1 > N 이 되면 종료

            if(!stack.isEmpty() && stack.peek()==v[idx]) {
                stack.pop();
                idx ++;
                answer.add("-");
            }
            else if (v[idx] < count) break;
            else {
                stack.push(count++);
                answer.add("+");
            }
        }

        if(idx == N) {
            for (String state:
                    answer) {
                System.out.println(state);
            }
        }else System.out.println("NO");
    }

}
