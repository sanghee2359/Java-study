package ps.array;

import java.util.Scanner;

public class Eratosthenes { // 소수가 아니면 1을 넣는 규칙
    public int solution(int n) {
        int answer = 0;
        int[] sieve = new int[n+1]; // n까지
        for (int i = 2; i <= n; i++) {
            if(sieve[i]==0) {
                answer++;
                for (int j = i; j <= n ; j+=i) {
                    sieve[j] = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Eratosthenes T = new Eratosthenes();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(T.solution(N));
    }
}
