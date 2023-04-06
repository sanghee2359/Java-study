package ps.stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// 왕자 N명이 공주를 구하러가기 위해 선정하고 있음
// 1 ~ N번째 왕자까지 시계방향으로 동그랗게 앉고, 1번부터 번호를 외친다.
// 한 왕자가 K(특정 숫자)를 외치면 그 왕자는 탈락
// 다음 왕자부터 다시 1부터 시작하며, 다음에 또 K를 외친 왕자가 탈락된다.
public class FindPrincess {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> prince = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            prince.add(i); // prince의 번호 넣음
        }
        System.out.println(prince);
        int idx = 0; // 몇 번째 왕자인지 알려주는 idx변수
        while(n != 1) {
            if(idx >= n) idx = 0;
            stack.push(prince.get(idx++));

//            for (int i = 0; i < stack.size(); i++) {
//                System.out.printf(stack.get(i)+" ");
//            }
//            System.out.println();

            // i번째 사람이 k를 부르면 탈락
            if(stack.size() == k) {
                prince.remove(idx-1); // arrayList에서 값 삭제
//                System.out.println("값 하나 삭제"+prince);
                stack.clear(); // 스택 초기화
                idx = idx-1; // 인덱스 초기화하면 안되지. 다음 인덱스부터 다시 돌아야함.
                n--;
            }
            // i번째 사람을 제외하고, 그 다음 사람부터 다시 1을 시작.
        }
        answer = prince.get(idx);
        return answer;
    }
    public static void main(String[] args) {
        FindPrincess T = new FindPrincess();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.solution(N, K));
    }
}
