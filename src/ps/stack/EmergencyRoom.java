package ps.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// N명의 대기목록 순서의 환자 위험도가 주어지면,
// 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램
// M번째 환자의 진료순서 구하기
// 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조
public class EmergencyRoom {
    public int solution(int n, int m, int[] danger) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0; i < danger.length; i++) {
            Q.offer(new Person(i, danger[i]));
        }
        while(!Q.isEmpty()){
            // 큐에 자기보다 큰 수의 위험도 환자가 있으면
            Person tmp = Q.poll();
            for(Person x : Q) {
                if(x.priority > tmp.priority){ // 꺼낸 person보다 위험도가 큰 person확인
                    Q.add(tmp);
                    tmp = null;
                    break; // for문 종료
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        EmergencyRoom T = new EmergencyRoom();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] danger = new int[N];
        for (int i = 0; i < N; i++) {
            danger[i] = sc.nextInt();
        }
        System.out.println(T.solution(N, M, danger));
    }
}
class Person {
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}