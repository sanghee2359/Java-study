package inflearn.Implementation;

import java.util.*;

public class MeetInTheConferenceRoom {
    public int[] solution(int[] enter, int[] exit){
        int[] answer = new int[exit.length+1];
        List<Integer> conferenceRoom = new ArrayList<>();
        // exit의 현재 인덱스 번호가 conference에
        // 존재하지 않는 번호라면,
        // 그 숫자가 나올 때까지 enter에서 추가
        // 반복문 필요
        int in_idx = 0, out_idx = 0;
        conferenceRoom.add(enter[in_idx]);
        while(out_idx != exit.length - 1) { // 마지막 사람까지 나갈때까지 반복
            int curNum = enter[in_idx];
            if(exit[out_idx] == enter[in_idx]) {
                out_idx++;
                int curIdx = conferenceRoom.indexOf(curNum);
                conferenceRoom.remove(curIdx); // 자기자신은 제외
                answer[curNum] = conferenceRoom.size();

              continue;
            }
            in_idx++;
            conferenceRoom.add(enter[in_idx]);



        }
        return answer;
    }

    public static void main(String[] args){
        MeetInTheConferenceRoom T = new MeetInTheConferenceRoom();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
//        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}