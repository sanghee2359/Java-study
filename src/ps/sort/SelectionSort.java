package ps.sort;

import java.util.*;

public class SelectionSort {
    private int[] Sort(int num, int[] each){
        for (int i = 0; i < num; i++) {
            int idx = i; //최소값의 index를 저장할 변수
            for (int j = i+1; j < num; j++) {
                if(each[j] < each[idx]) {
                    idx = j;
                }
            }
            // i의 위치와 최소값의 swap
            int tmp = 0;
            tmp = each[idx];
            each[idx] = each[i];
            each[i] = tmp;
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
