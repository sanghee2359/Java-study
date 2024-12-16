package inflearn.Implementation;

import java.util.*;

public class MeetInTheConferenceRoom {
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        int[] enterIdx = new int[n];
        int[] enterT = new int[n];
        int[] exitT = new int[n];
        for (int i = 0; i < n; i++) {
            enter[i]--;
            exit[i]--;
        }
        // 입실 순서 저장
        for (int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }
        System.out.println(Arrays.toString(enterIdx));
        int time = 0;
        for (int i = 0, j = 0; i < n; i++) {
            while(j < n && j <= enterIdx[exit[i]]) {// j는
                enterT[enter[j]] = time++;
                j++;
            }
            exitT[exit[i]] = time++;
        }
        System.out.println(Arrays.toString(enterT));
        System.out.println(Arrays.toString(exitT));
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(!( (exitT[i] < enterT[j] ) || (exitT[j] < enterT[i]) )) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        MeetInTheConferenceRoom T = new MeetInTheConferenceRoom();
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}