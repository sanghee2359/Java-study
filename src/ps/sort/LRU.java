package ps.sort;

import java.util.*;

public class LRU {
    private int[] Sort(int size, int[] arr) {
        int[] cache = new int[size];
        // cache hit 체크
        for (int x:
             arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) if(x == cache[i]) pos=i; // hit된 지점을 저장
            if(pos == -1) {
                for (int j = size-1; j >= 1; j--) {
                    // cache miss
                    cache[j] = cache[j-1];
                }
            }else {
                for (int j = pos; j >= 1; j--) {
                    // cache miss
                    cache[j] = cache[j-1];
                }
            }
            cache[0] = x;
        }
        return cache;
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
