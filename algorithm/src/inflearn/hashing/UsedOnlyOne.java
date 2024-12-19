package inflearn.hashing;

import java.util.HashMap;

public class UsedOnlyOne {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, int[]> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(!charMap.containsKey(cur)) charMap.put(cur, new int[]{i + 1, 1});
            else { // 포함되어 있을 경우
                int num = charMap.get(cur)[1] + 1;
                charMap.put(cur, new int[]{i+1, num});
            }
        }
        int min = Integer.MAX_VALUE;
        for (Character key : charMap.keySet()) {
            if(charMap.get(key)[1] == 1 && min > charMap.get(key)[0]){
                min = charMap.get(key)[0];
            }
        }
        answer = (min == Integer.MAX_VALUE)? -1 : min;
        return answer;
    }

    public static void main(String[] args){
        UsedOnlyOne T = new UsedOnlyOne();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
