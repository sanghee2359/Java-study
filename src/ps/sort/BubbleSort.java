package ps.sort;

import java.util.Scanner;

public class BubbleSort {
    public int[] Sort(int num, int[] arr) {
        for (int i = 0; i < num-1; i++) {
            for (int j = 0; j < num-i-1; j++) { // i가 1씩 증가함에 따라 j의 최대도 1씩 감소
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
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
