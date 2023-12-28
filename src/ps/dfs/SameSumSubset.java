package ps.dfs;

import java.util.Arrays;
import java.util.Scanner;

//N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
//
//두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
public class SameSumSubset {
    static int whole;
    static String answer = "NO";
    static int[] arr;
    public void DFS(int n, int sum) {
        if(n == arr.length-1) {
            System.out.println("a:"+sum);
            System.out.println("b:"+(whole - sum));
            if(sum == (whole-sum)) answer = "YES";
        }
        else {
            sum += arr[n];
            DFS(n+1, sum);
            sum -= arr[n];
            DFS(n+1, sum);
        }
    }
    public static void main(String[] args) {
        SameSumSubset O = new SameSumSubset();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            whole += arr[i];
        }
        int sum = 0;
        O.DFS(0, sum);
        System.out.println(answer);
    }
}
