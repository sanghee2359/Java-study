package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다
public class boj_10828 {
    static int[] stack;
    static int size = 0;
    public int top() {
        if(size == 0) return -1;
        else return stack[size - 1]; // 스택의 최상단
    }
    public int pop() {
        if(size == 0) return -1;
        else {
            int tmp = stack[size-1]; // 스택의 최상단 출력
            stack[size-1] = 0;
            size--; // 값이 하나 pop 되므로, size - 1
            return tmp;
        }
    }
    public int size() {
        return size;
    }
    public int empty() {
        if(size == 0) return 1;
        else return 0;
    }
    public void push(int num) {
        stack[size] = num;
        size++;
    }

    public static void main(String[] args) throws IOException {
        boj_10828 T = new boj_10828();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stack  = new int[N];
        while(N-->0) {
            String str = br.readLine();
            if(str.contains("push")) {
                String[] arr = str.split(" ");
                T.push(Integer.parseInt(arr[1]));
            }else if(str.contains("top")) sb.append(T.top()).append('\n');
            else if(str.contains("size")) sb.append(T.size()).append('\n');
            else if(str.contains("pop")) sb.append(T.pop()).append('\n');
            else if(str.contains("empty")) sb.append(T.empty()).append('\n');

        }
        System.out.println(sb);
    }
}
