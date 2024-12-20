package inflearn.hashing;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class CreateSameFrequency {
    private int[] solution(String string) {
        int[] answer = new int[5];
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : string.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // 키의 default 값 0
        }
        // 최대값 탐색
        int maxValue = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()) {
            if(map.getOrDefault(key, 0) > maxValue) {
                maxValue = map.getOrDefault(key, 0);
            }
        }
        // a, b, c, d, e 각 키들의 값을 가져와 max값과 비교 후 필요한 숫자만큼 answer 배열에 저장
        for (int i = 0; i < tmp.length(); i++) {
            answer[i] = maxValue - map.getOrDefault(tmp.charAt(i), 0);
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

