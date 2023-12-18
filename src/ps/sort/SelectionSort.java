package ps.sort;

import java.util.*;

public class SelectionSort {
    private int[] Sort(int num, int[] each){
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-1; j++) {
                if(each[j] > each[j+1]) {
                    int tmp = 0;
                    tmp = each[j];
                    each[j] = each[j+1];
                    each[j+1] = tmp;
                }
            }
        }

        return each;
    }

    public static void main(String[] args) {
        SelectionSort O = new SelectionSort();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] each = new int[num];
        for (int i = 0; i < num; i++) {
            each[i] = in.nextInt();
        }
        O.Sort(num, each);  // 정렬 메소드 실행
        for(int x : each) {
            System.out.print(x+" ");
        }
    }
}
