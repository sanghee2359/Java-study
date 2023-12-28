package ps.dfs;

import java.util.Arrays;
import java.util.Scanner;

//N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
//
//두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
public class SameSumSubset {
    static int n, whole;
    static String answer = "NO";
    boolean flag = false; // Yes가 발견된 다음 재귀는 모두 return
    public void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > whole/2) return; //sum이 전체합의 절반을 넘을 때 조건을 충족시킬 수 없으므로 return
        if(L == n) {
            System.out.println("a:"+sum);
            System.out.println("b:"+(whole - sum));
            if(sum == (whole-sum)) {
                answer = "YES";
                flag = true;
            }
        }
        else {
            DFS(L+1, sum += arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args) {
        SameSumSubset O = new SameSumSubset();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            whole += arr[i];
        }
        int sum = 0;
        O.DFS(0, sum, arr);
        System.out.println(answer);
    }
}
