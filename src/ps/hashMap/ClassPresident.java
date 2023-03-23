package ps.hashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

// 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
// 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며
// 선생님은 그 기호를 발표하고 있습니다.
public class ClassPresident {
    public char solution(int n, String str) {
        char answer;
        HashMap<Character, Integer> vote = new HashMap<>();
        for (char i = 'A'; i < 'D'; i++) {
            vote.put(i, 0);
        }
        for (int i = 0; i < str.length(); i++) {
            vote.put(str.charAt(i),vote.get(str.charAt(i))+1);
        }
        answer = Collections.max(vote.keySet());
        return answer;
    }
    public static void main(String[] args) {
        ClassPresident T = new ClassPresident();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.nextLine();
        System.out.println(T.solution(N, str));
    }
}
