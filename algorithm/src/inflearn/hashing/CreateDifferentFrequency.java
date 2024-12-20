package inflearn.hashing;

import java.util.HashMap;

public class CreateDifferentFrequency {
    private  int solution(String s) {
        // 문자열의 숫자를 지워, 모든 문자의 빈도수가 서로 다르게 만드려 한다
        // 최소로 문자를 지워서 서로다른 문자열 빈도수가 되도록 하는, 지워야 할 최소개수를 반환하시요
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // 값이 서로 다르도록 만드는 법
        // 일단 값이 작을 수록 지우면 더 편해보인다.
        // 그래도 우선 조건은, 같은 entry 중에 겹치는 값이 있을 것.

        int count = 0;
        // 값이 겹치는 게 있는지 어케확인함?
        for(char key : map.keySet()) {
            int tmpValue = map.get(key); // 값 출력
            // contains에서 자기자신을 제외해서
            // 현재 값과 같은 값이 있는가? 를 체크 해야 하는데, 자기 자신까지 포함하는 바람에 계속 -1 되고 있다
            while(map.containsValue(tmpValue)){
                map.put(key, map.getOrDefault(key, 0) - 1);
                count++;
            }
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
