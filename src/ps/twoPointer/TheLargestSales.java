package ps.twoPointer;

import java.util.Scanner;

public class TheLargestSales {
    public int solution(int n, int k, int[] arr){
        int answer = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum; // 초기값 = 첫번째 매출합
        for (int i = k; i < n; i++) {
            sum+=(arr[i]-arr[i-k]);
            answer = Math.max(answer, sum);
        }
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
