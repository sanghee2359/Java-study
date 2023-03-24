package ps.array;

import java.util.ArrayList;
import java.util.Scanner;

// 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력
// 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램

// 1: 가위 2: 바위 3: 보
public class RockScissorsPapper {
    public ArrayList<Character> solution(int n, int[] arrA, int[] arrB) {
        ArrayList<Character> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(arrA[i]==arrB[i]) answer.add('D');
            else if(arrA[i]==1 && arrB[i]==3) answer.add('A');
            else if(arrA[i]==2 && arrB[i]==1) answer.add('A');
            else if(arrA[i]==3 && arrB[i]==2) answer.add('A');
            else answer.add('B');
        }
        return answer;
    }
    public static void main(String[] args) {
        RockScissorsPapper T = new RockScissorsPapper();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }
        int[] arrB = new int[N];
        for (int i = 0; i < N; i++) {
            arrB[i] = sc.nextInt();
        }
        for (char x :
                T.solution(N, arrA, arrB)) {
            System.out.println(x);
        }
    }
}
