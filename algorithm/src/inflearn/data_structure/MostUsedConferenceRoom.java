package inflearn.data_structure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MostUsedConferenceRoom {
    public int solution(int n, int[][] meetings) {
        int max = 0, idx = 0;
        int[] result = new int[n];
        TreeSet<Integer> rooms = new TreeSet<>();
        PriorityQueue<int[]> usingRoom = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            rooms.add(i); // 회의실 방 번호 오름차순 정렬
        }
        Arrays.sort(meetings, (a, b)-> a[0] - b[0]); // 도착시간 기준으로 정렬
        for(int[] m : meetings) {
            // 현재 도착시간 >= 회의실 이용종료 시간 -> 회의실 비었다
            while(!usingRoom.isEmpty() && usingRoom.peek()[0] <= m[0]) rooms.add(usingRoom.poll()[1]); // 회의실 방 번호
            if(!rooms.isEmpty()) { // 회의실이 사용 가능하다면
                int room = rooms.pollFirst();
                result[room]++;
                usingRoom.add(new int[]{m[1], room}); // 이용 종료 시간, 방번호
            } else { // 회의실 사용이 만석이라면
                int[] endMeeting = usingRoom.poll(); // 가장 먼저 끝날 회의 꺼내오기
                result[endMeeting[1]]++;
                usingRoom.add(new int[]{endMeeting[0] + (m[1] - m[0]), endMeeting[1]});
            }
        }

        for (int i = 0; i < n; i++) {
            if(max < result[i]){
                max = result[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args){
        MostUsedConferenceRoom T = new MostUsedConferenceRoom();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
