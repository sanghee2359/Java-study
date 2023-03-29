package ps.array;
// 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램

import java.util.Scanner;

public class Eratos {
    public int solution(int n) {
        int answer = 0;
        int[] arr=new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i]=i;
        }
        arr[1]=0; // 1을 0으로 전환(소수가 아니므로)
        // 소수의 배수인 것 찾아서 0으로 전환
        for(int multipleOf=2; multipleOf*multipleOf<=n; multipleOf++) {
            for (int i = multipleOf * 2; i <= n; i += multipleOf) {
                arr[i] = 0;
            }
        }
        for(int i=2; i<n; i++) {
            if(arr[i]>0) {
                System.out.printf("%d ", arr[i]);
                answer++;
            }
        }
        System.out.println();
        return answer;
    }
    public static void main(String[] args) {
        Eratos T = new Eratos();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(T.solution(N));
    }
}
