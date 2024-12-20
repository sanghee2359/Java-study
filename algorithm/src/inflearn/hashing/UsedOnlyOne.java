package inflearn.hashing;

import java.util.HashMap;

public class UsedOnlyOne {
    public int solution(String s){
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char x : s.toCharArray()){
            charMap.put(x, charMap.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(charMap.get(s.charAt(i)) == 1) return i+1;
        }
        return -1;
    }

    public static void main(String[] args){
        UsedOnlyOne T = new UsedOnlyOne();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
