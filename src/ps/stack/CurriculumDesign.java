package ps.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 필수과목이 CBA로 주어지면 필수과목은 C, B, A 과목이며 이 순서대로 꼭 수업계획을 짜야 합니다
// 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램
// 반드시 연속이어야하는게 아니고, 순서만 맞으면 OK
public class CurriculumDesign {

    public String solution(String essential, String subject) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (int i = 0; i < essential.length(); i++) Q.offer(essential.charAt(i));
        // String을 순회하며 앞에 Q의 과목이 있는지 체크하는 방식으로 해보자
        for (char x : subject.toCharArray()) {
            if(Q.contains(x)) {
                if(Q.poll()!=x) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO"; // 필수과목을 이수하지 않은 경우
        return answer;
    }
    public static void main(String[] args) {
        CurriculumDesign T = new CurriculumDesign();
        Scanner sc = new Scanner(System.in);
        String essential = sc.nextLine();
        String subject = sc.nextLine();
        System.out.println(T.solution(essential, subject));
    }
}
