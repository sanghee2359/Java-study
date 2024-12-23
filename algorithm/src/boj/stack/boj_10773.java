package boj.stack;

import java.util.Scanner;
import java.util.Stack;

public class boj_10773 {
    public static void main(String[] args) {
        // 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt(), sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(tmp == 0 && !stack.isEmpty()) stack.pop();
            else stack.push(tmp);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
