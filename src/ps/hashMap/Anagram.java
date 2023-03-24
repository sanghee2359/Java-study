package ps.hashMap;

import java.util.HashMap;
import java.util.Scanner;

// Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 한다.
// 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램
// 판별 시 대소문자가 구분
public class Anagram {
    public String solution(String str1, String str2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        // map input
        for(char x : str1.toCharArray()) {
            map.put(x,map.getOrDefault(x, 0)+1);
        }
        // 비교
        for(char x : str2.toCharArray()) {
            // key가 존재하지 않거나, 0이 되어있을 경우
            if (!map.containsKey(x) || map.get(x)==0) return "NO";
            map.put(x, map.get(x)-1);
        }

        return answer;
    }
    public static void main(String[] args) {
        Anagram T = new Anagram();
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(T.solution(str1, str2));
    }
}
