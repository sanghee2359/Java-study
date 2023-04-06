package ps.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindPrincess2 {
    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            Q.offer(i); // 1~n의 값 넣음
        }
        while(Q.size() != 1) {
            for (int i = 0; i < k-1; i++) {
                int tmp = Q.poll();
                Q.offer(tmp);
            }
            int K = Q.poll();
            System.out.println("내보낼 K번째 왕자 :"+ K);
        }
        answer = Q.element();
        return answer;
    }
    public static void main(String[] args) {
        FindPrincess2 T = new FindPrincess2();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.solution(N, K));
    }
}
