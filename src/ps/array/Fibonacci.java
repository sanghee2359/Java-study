package ps.array;
// 첫 줄에 피보나치 수열을 출력
// 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
// 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    public ArrayList<Integer> solution(int num) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1); // i = 0
        answer.add(1); // i = 1

        for (int i = 2; i < num; i++) {
            answer.add(answer.get(i-1)+answer.get(i-2));
        }
        return answer;
    }
    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int x:
             T.solution(num)) {
            System.out.printf(x+" ");
        }
    }
}
