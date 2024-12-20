package inflearn.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CreateDifferentFrequency {
    private  int solution(String s) {
        // 문자열의 숫자를 지워, 모든 문자의 빈도수가 서로 다르게 만드려 한다
        // 최소로 문자를 지워서 서로다른 문자열 빈도수가 되도록 하는, 지워야 할 최소개수를 반환하시요
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        // 값이 겹치는 게 있는지 어케확인함? -> set을 통해 겹치는 값이 있는지 비교
        for(char key : map.keySet()) {
            while(set.contains(map.get(key))) { //set안의 값과 겹치는 값이 없을 때까지 1씩 감소
                map.put(key, map.getOrDefault(key, 0) - 1);
                count++;
            }
            // 값이 존재하지 않을 경우 -> set에 저장
            if(map.get(key) > 0) set.add(map.get(key));
        }
        return count;
    }
    public static void main(String[] args){
        CreateDifferentFrequency T = new CreateDifferentFrequency();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
