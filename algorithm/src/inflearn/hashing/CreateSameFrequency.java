package inflearn.hashing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CreateSameFrequency {
    private int[] solution(String string) {
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : string.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // 키의 default 값 0
        }
        int maxValue = Collections.max(map.values());
        int idx = 0;
        for (char i = 'a'; i < 'f'; i++) {
            // a, b, c, d, e 에서 채워야할 개수만큼 answer 배열에 저장
            answer[idx++] = maxValue - map.getOrDefault(i, 0);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        CreateSameFrequency T = new CreateSameFrequency();

        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}

