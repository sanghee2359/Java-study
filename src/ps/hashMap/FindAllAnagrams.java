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
        Map<Character, Integer> HM = new HashMap<>();
        // t문자열-1크기만큼 s문자열을 map에 저장
        for (int i = 0; i < t.length()-1; i++) {
            HM.put(s.charAt(i), HM.getOrDefault(s.charAt(i), 0)+1);
        }
        // 왼쪽부터 sliding window를 이용하여 비교
        int lt = 0;
        for (int rt = t.length()-1; rt < s.length(); rt++) {
            HM.put(s.charAt(rt), HM.getOrDefault(s.charAt(rt), 0)+1);
            // map과 t를 비교
            int count = 0;
            for(char x : t.toCharArray()){ // t와 같은 문자가 없거나, 키의 값이 0이라면
                if(!HM.containsKey(x) || HM.get(x)==0) continue;
                count++;
            }
            if(count==t.length()) answer++;
            HM.put(s.charAt(lt),HM.get(s.charAt(lt))-1); // 왼쪽 -1제거(한 칸이동)
            if(HM.get(s.charAt(lt))==0) HM.remove(s.charAt(lt)); // 값이 없다면 삭제
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
