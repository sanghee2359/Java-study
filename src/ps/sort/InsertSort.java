package ps.sort;

import java.util.Scanner;

public class InsertSort {
    private int[] Sort(int num, int[] arr) {
        for (int i = 0; i < num-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        
        return arr;
    }
    public static void main(String[] args) {
        InsertSort O = new InsertSort();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : O.Sort(num, arr)){
            System.out.printf(x+" ");
        }
    }
}
