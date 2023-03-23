package ps.array;

import java.util.ArrayList;
import java.util.Scanner;

// N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램
public class OutputLargeNum {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        OutputLargeNum T = new OutputLargeNum();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int x : T.solution(N, arr)){
            System.out.printf(x+" ");
        }
    }
}
