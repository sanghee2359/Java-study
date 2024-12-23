package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10773 {
    public static void main(String[] args) throws IOException {
        // 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), sum = 0;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0 ){
                stack[top] = 0;
                top--;
            }
            else {
                top++;
                stack[top] = tmp;
            }
        }
        for (int i = 0; i < stack.length; i++) {
            sum += stack[i];
        }
        System.out.println(sum);
        br.close();
    }
}
