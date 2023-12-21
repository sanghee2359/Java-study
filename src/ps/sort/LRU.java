package ps.sort;

import java.util.Scanner;

public class LRU {
    private int[] Sort(int size, int[] arr) {
        int[] cache = new int[size];
        for (int x: arr) {
            int pos = -1;
            for (int i = size-1; i >= 1; i--) {
                if(x == cache[i]) pos = x;
            }
            if(pos == -1) {
                for (int i = size-1; i >= 1 ; i--) {
                    cache[i] = cache[i-1];
                }
            }else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
    public static void main(String[] args) {
        LRU O = new LRU();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : O.Sort(size, arr)){
            System.out.printf( x+" " );
        }
    }

}