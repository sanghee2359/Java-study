package ps.sort;

import java.util.*;

public class LRU {
    private int[] Sort(int size, int[] arr) {
        Queue<Integer> cache = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(cache.size() == size) cache.poll();
            else if (cache.contains(arr[i])){
                cache.remove(arr[i]);
            }
            cache.add(arr[i]);
        }
        for (int i = 0; i < size; i++) {
            answer.add(cache.poll());
        }
        Collections.reverse(answer);
        int[] answerArr = new int[size];
        int idx = 0;
        for (int x:
             answer) {
            answerArr[idx++] = x;
        }
        return answerArr;
    }
    public static void main(String[] args) {
        LRU O = new LRU();
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        for (int x:
                O.Sort(size, arr)) {
            System.out.printf(x + " ");
        }
    }
}
