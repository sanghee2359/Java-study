package ps.twoPointer;

import java.util.Scanner;

public class TheLargestSales {
    public int solution(int n, int k, int[] arr){
        int answer = 0;
        int lt = 0, rt = k-1;
        int max = Integer.MIN_VALUE;
        while(rt < n){
            int sum = 0;
            for (int i = lt; i <= rt ; i++) {
                sum += arr[i];
            }
            if(max < sum) max = sum;
            rt++;
            lt++;
        }
        answer = max;
        return answer;
    }
    public static void main(String[] args) {
        TheLargestSales T = new TheLargestSales();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(T.solution(N,K,arr));
    }
}
