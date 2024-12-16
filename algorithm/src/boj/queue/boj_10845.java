package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다
public class boj_10845 {
    static int[] queue;
    static int first = 0;
    static int last = 0;
    public int pop() {
        if(last - first == 0) return -1;
        else {
            int tmp = queue[first]; // 스택의 최상단 출력
            first++;
            return tmp;
        }
    }
    public int size() {
        return last - first;
    }
    public int empty() {
        if(last - first == 0) return 1;
        else return 0;
    }
    public int front() {
        if(last - first == 0) return -1;
        else {
            return queue[first]; // 스택의 최상단
        }
    }
    public void push(int num) {
        queue[last] = num;
        last++;
    }
    public int back() {
        if(last - first == 0) {
            return -1;
        }else {
            int back = queue[last - 1];
            return back;
        }
    }

    public static void main(String[] args) throws IOException {
        boj_10845 T = new boj_10845();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        queue  = new int[N];
        while(N-->0) {
            String str = br.readLine();
            if(str.contains("push")) {
                String[] arr = str.split(" ");
                T.push(Integer.parseInt(arr[1]));
            }else if(str.contains("pop")) sb.append(T.pop()).append('\n');
            else if(str.contains("size")) sb.append(T.size()).append('\n');
            else if(str.contains("back")) sb.append(T.back()).append('\n');
            else if(str.contains("front")) sb.append(T.front()).append('\n');
            else if(str.contains("empty")) sb.append(T.empty()).append('\n');

        }
        System.out.println(sb);
    }
}
