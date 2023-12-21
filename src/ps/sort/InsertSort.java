package ps.sort;

import java.util.Scanner;

public class InsertSort {
    private int[] Sort(int num, int[] arr) {
        for (int i = 1; i < num; i++) {
            int tmp = arr[i], j;
            for (j = i-1; j >= 0; j--) {
                if(arr[j] > tmp) {
                    // 값을 한칸 이동
                    arr[j + 1] = arr[j];
                } else break;
            }
            // j가 멈춘부분 다음에 arr[]=tmp 저장
            arr[j+1] = tmp;
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
