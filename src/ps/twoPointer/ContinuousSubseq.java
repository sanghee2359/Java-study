package ps.twoPointer;
// 수열 N에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램
// 조건 1.연속 부분 수열
// 이중 for문으로 풀면 O(N^2)이고, 투 포인터로 풀면 O(N)으로 처리할 수 있다.

import java.util.Scanner;

public class ContinuousSubseq {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt = 0, sum = 0;
        for (rt = 0; rt < n; rt++) {
            sum += arr[rt]; // rt가 하나씩 증가
            if(sum==m) answer++;
            while(sum>=m) {
                // lt를 하나 삭제
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ContinuousSubseq T = new ContinuousSubseq();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); // 합이 M인 수 만들기
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N,M,arr));
    }
}
