package ps.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램
// 조건 1. 아나그램 판별시 대소문자가 구분된다.
// 조건 2. 부분문자열은 연속된 문자열이어야 합니다.
public class FindAllAnagrams {
    public int solution(String s, String t) {
        int answer = 0;
        Map<Character, Integer> tm = new HashMap<>();
        Map<Character, Integer> sm = new HashMap<>();
        for (char x : t.toCharArray()) tm.put(x, tm.getOrDefault(x, 0)+1);
        // s문자열 map
        int L = t.length()-1;
        for (int i = 0; i < L; i++) sm.put(s.charAt(i), sm.getOrDefault(s.charAt(i), 0)+1);
        // 비교 (sliding window)
        int lt = 0;
        for (int rt = L; rt < s.length(); rt++) {
            sm.put(s.charAt(rt), sm.getOrDefault(s.charAt(rt), 0)+1);
            if(sm.equals(tm)) answer++;
            // 왼쪽 한칸이동
            sm.put(s.charAt(lt),sm.get(s.charAt(lt))-1);
            if(sm.get(s.charAt(lt))==0) sm.remove(s.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        FindAllAnagrams T = new FindAllAnagrams();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(T.solution(s, t));

    }
}
