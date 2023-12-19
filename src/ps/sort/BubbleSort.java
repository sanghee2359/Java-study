package ps.sort;

import java.util.Scanner;

public class BubbleSort {
    public int[] Sort(int num, int[] arr) {
        int idx = num-1;
        for (int i = 0; i < num-1; i++) {
            for (int j = 0; j < idx; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            idx--; // n회전 할 때마다 1감소
        }
        return arr;
    }
    public static void main(String[] args) {
        BubbleSort O = new BubbleSort();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] each = new int[num];

        for (int i = 0; i < each.length; i++) {
            each[i] = in.nextInt();
        }
        O.Sort(num, each);
        for (int x:
             each) {
            System.out.printf(x+" ");
        }
    }
}
