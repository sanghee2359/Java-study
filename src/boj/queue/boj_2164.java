package boj.queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2164 {
    //  N(1 ≤ N ≤ 500,000)
    public static Queue<Integer> queue;
    public static int function() {
        while(queue.size() != 1) {
            queue.poll();
            if(queue.size() > 1) {
                queue.offer(queue.poll());
            }
        }
        return queue.poll();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        System.out.println(function());

    }
}
