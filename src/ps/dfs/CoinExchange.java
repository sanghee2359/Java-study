package ps.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주는 프로그램
// 동전의 종류 개수 : 1 <= n <= 12
// 거슬러 줄 금액 : 1 <= m <= 500
public class CoinExchange {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if(sum > m) return;
        if(L >= answer) return;
        if(sum == m) {
            answer = Math.min(L, answer);
        }else {
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        CoinExchange O = new CoinExchange();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer [] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        O.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
