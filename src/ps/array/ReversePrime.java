package ps.array;
//N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램

import java.util.ArrayList;
import java.util.Scanner;

public class ReversePrime {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 숫자를 역순으로 뒤집는다.
        for (int i = 0; i < n; i++) {
            arr[i] = flip(arr[i]);
        }
        // 소수인지 판별한다.
        for (int i = 0; i < n; i++) {
            if(isPrime(arr[i])) answer.add(arr[i]);
        }
        return answer;
    }
    public int flip(int num) {
        int result = 0;
        while(num != 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
    public boolean isPrime(int num) {
        if(num == 1) return false;
        for (int i = 2; i <= (int)Math.sqrt(num) ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ReversePrime T = new ReversePrime();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(N, arr)) {
            System.out.print(x+" ");
        }
    }
}
